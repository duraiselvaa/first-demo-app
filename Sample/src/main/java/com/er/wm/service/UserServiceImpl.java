package com.er.wm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.er.wm.dao.UserDao;
import com.er.wm.model.User;

/**
 * Implementation of UserService, with methods to handle the users.
 * @author Others
 *
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * Saves the user
	 */

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false) 
	public User addUser(User user) {
		logger.info("adding the user : "+user.getEmailId());
		userDao.saveUser(user);	
		
		logger.info("fetching the saved user back to get the id : "+user.getEmailId());
		User savedUser = userDao.getUser(user.getEmailId());
		return savedUser;
	}
	/**
	 * Fetch the list of all registered users in the system
	 */
	public List<User> listUsers() {
		return userDao.listUsers();
	}
	/**
	 * Fetch the user with the given email id. Used to check the duplicated email id.
	 */
	public User getUser(String emailId) {
		return userDao.getUser(emailId);
	}
	/**
	 * Fetch the user wiht the gievn email id and password. Used for login.
	 */
	public User getUser(String emailId, String password) {
		return userDao.getUser(emailId, password);
	}	
}
