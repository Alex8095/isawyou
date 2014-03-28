package com.frogorf.isawyou.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.frogorf.isawyou.domain.User;
import com.frogorf.isawyou.service.IsawyouService;

/** Handles requests for the application home page. */
@Controller
@SessionAttributes(types = User.class)
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IsawyouService isawyouService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "users/createOrUpdateForm";
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid User user, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "users/createOrUpdateForm";
		} else {
			this.isawyouService.saveUser(user);
			status.setComplete();
			return "redirect:/users/" + user.getId();
		}
	}

	@RequestMapping(value = "/users/find", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		model.addAttribute("user", new User());
		return "users/findUsers";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String processFindForm(User user, BindingResult result, Model model) {
		// allow parameterless GET request for /users to return all records
		if (user.getLastName() == null) {
			user.setLastName(""); // empty string signifies broadest possible
			// search
		}

		// find users by last name
		List<User> results = this.isawyouService.findUserByLastName(user.getLastName());
		if (results.size() < 1) {
			// no users found
			result.rejectValue("lastName", "notFound", "not found");
			return "users/findUsers";
		}
		if (results.size() > 1) {
			// multiple users found
			model.addAttribute("selections", results);
			return "users/usersList";
		} else {
			// 1 User found
			user = results.iterator().next();
			return "redirect:/users/" + user.getId();
		}
	}

	@RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
	public String initUpdateUserForm(@PathVariable("userId") int userId, Model model) {
		User user = this.isawyouService.findUserById(userId);
		model.addAttribute(user);
		return "users/createOrUpdateForm";
	}

	@RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.PUT)
	public String processUpdateUserForm(@Valid User user, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "users/createOrUpdateForm";
		} else {
			this.isawyouService.saveUser(user);
			status.setComplete();
			return "redirect:/users/{userId}";
		}
	}

	/** Custom handler for displaying an user.
	 * 
	 * @param userId the ID of the User to display
	 * @return a ModelMap with the model attributes for the view */
	@RequestMapping("/users/{userId}")
	public ModelAndView showUser(@PathVariable("userId") int userId) {
		ModelAndView mav = new ModelAndView("users/details");
		mav.addObject(this.isawyouService.findUserById(userId));
		return mav;
	}
}
