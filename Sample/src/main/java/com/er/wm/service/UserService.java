package com.er.wm.service;

import java.util.List;

import com.er.wm.model.User;

public interface UserService {
	
	  public User addUser(User article);

	  public List<User> listUsers();
	  
	  public User getUser(String emailId);
	  
	  public User getUser(String emailId, String password);

}
