package com.er.wm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.er.wm.model.User;

/**
 * Implementation of UserDao, with method to help with the CRUD operation for users
 * @author Others
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Saves the user
	 */
	public void saveUser(User user) {
		logger.info("Registering the user : "+sessionFactory.getCurrentSession());
		sessionFactory.getCurrentSession().saveOrUpdate(user);		
	}
	/**
	 * Fetch the list of all registered users in the system
	 */
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {		
		return (List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}
	/**
	 * Fetch the user with the given email id. Used to check the duplicated email id.
	 */
	public User getUser(String emailId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("emailId", emailId).ignoreCase());
		User user = (User) criteria.uniqueResult();
		return user;
	}
	/**
	 * Fetch the user wiht the gievn email id and password. Used for login.
	 */
	public User getUser(String emailId, String password) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("emailId", emailId).ignoreCase());
		criteria.add(Restrictions.eq("password", password));
		User user = (User) criteria.uniqueResult();
		return user;
	}
}
