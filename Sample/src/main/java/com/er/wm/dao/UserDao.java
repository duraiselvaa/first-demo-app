package com.er.wm.dao;

import java.util.List;

import com.er.wm.model.User;


public interface UserDao {
	  public void saveUser ( User user );
	  
	  public List<User> listUsers();
	  
	  public User getUser (String emailId);
	  
	  public User getUser (String emailId, String password);
	}
