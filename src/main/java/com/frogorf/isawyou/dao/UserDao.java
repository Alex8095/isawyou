/**
 * 
 */
package com.frogorf.isawyou.dao;

import java.util.List;

import com.frogorf.isawyou.domain.User;

/** @author Tsurkin Alex
 * @version */
public interface UserDao {

	public List<User> findUserAll();

	public User findUserById(int id);

	public void saveUser(User user);

	public void deleteUser(User user);

	public void deleteUser(int id);
}
