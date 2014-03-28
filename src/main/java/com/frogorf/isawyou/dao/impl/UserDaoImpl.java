/**
 * 
 */
package com.frogorf.isawyou.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frogorf.isawyou.dao.UserDao;
import com.frogorf.isawyou.domain.User;

/** @author Tsurkin Alex
 * @version */
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.isawyou.dao.UserDao#findAll() */
	@Override
	@Transactional(readOnly = true)
	public List<User> findUserAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.isawyou.dao.UserDao#findById(java.lang.int) */
	@Override
	public User findUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.isawyou.dao.UserDao#save(com.frogorf.isawyou.domain.User) */
	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	/* (non-Javadoc)
	 * 
	 * @see
	 * com.frogorf.isawyou.dao.UserDao#delete(com.frogorf.isawyou.domain.User) */
	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	/* (non-Javadoc)
	 * 
	 * @see com.frogorf.isawyou.dao.UserDao#delete(java.lang.int) */
	@Override
	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
