/**
 * 
 */
package com.frogorf.isawyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.isawyou.dao.UserDao;
import com.frogorf.isawyou.domain.User;
import com.frogorf.isawyou.service.IsawyouService;

/** @author Tsurkin Alex
 * @version */
@Service("userService")
@Repository
@Transactional
public class IsawyouServiceImpl implements IsawyouService {

	@Autowired
	private UserDao userDao;

	/* public IsawyouServiceImpl(UserDao userDao) { this.userDao = userDao; } */

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.isawyou.service.UserService#findAll() */
	@Override
	@Transactional(readOnly = true)
	public List<User> findUserAll() {
		return userDao.findUserAll();
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.isawyou.service.UserService#findById(java.lang.int) */
	@Override
	@Transactional(readOnly = true)
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.isawyou.service.UserService#save(com.frogorf.isawyou.domain
	 * .User) */
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.isawyou.service.UserService#delete(com.frogorf.isawyou.domain
	 * .User) */
	@Override
	@Transactional(readOnly = true)
	public void deleteUser(User user) {
		userDao.deleteUser(user);

	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.isawyou.service.UserService#delete(java.lang.int) */
	@Override
	@Transactional(readOnly = true)
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.isawyou.service.UserService#findAllByPage(org.springframework
	 * .data.domain.Pageable) */
	@Override
	@Transactional(readOnly = true)
	public Page<User> findUserAllByPage(Pageable pageable) {
		return null;
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.isawyou.service.IsawyouService#findUserByLastName(java.lang
	 * .String) */
	@Override
	public List<User> findUserByLastName(String lastName) {
		return null;
	}
}
