/**
 * 
 */
package com.frogorf.isawyou.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.frogorf.isawyou.domain.User;

/** @author Tsurkin Alex
 * @version */
public interface IsawyouService {

	public List<User> findUserAll();

	public User findUserById(int id);

	public List<User> findUserByLastName(String lastName);

	public void saveUser(User user);

	public void deleteUser(User user);

	public void deleteUser(int id);

	public Page<User> findUserAllByPage(Pageable pageable);
}
