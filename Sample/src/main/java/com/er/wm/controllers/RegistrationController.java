package com.er.wm.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.er.wm.model.User;
import com.er.wm.service.UserService;
import com.er.wm.validators.UserValidator;

/**
 * Handles requests for the Registration Page.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator validator;
	
	/**
	 * Validates and registers the new user. 
	 * @param user
	 * @param result
	 * @param session
	 * @return The welcome page if successful, the registration page with error messages otherwise
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("addUser");
		}
		ModelAndView registrationView = new ModelAndView("addUser");
		ModelAndView welcomeView = new ModelAndView("welcome");
		try {
			logger.info("Registering a new user "+ user.getEmailId());
			/*Note: all the users are of the same type for now. This needs to be revisted during User management module */
			user.setType(1);

			User exsistingUser = userService.getUser(user.getEmailId());
			if(exsistingUser != null) {
				logger.error("Email Id already exists" ); 
				registrationView.addObject("error", "EmailId.exists"); 
				return registrationView;   
			}
			
			User savedUser = userService.addUser(user);
			session.setAttribute("user_id", savedUser.getId());
			session.setAttribute("user_email", savedUser.getEmailId());
		}
    	catch (org.hibernate.exception.ConstraintViolationException ex1) {
       		logger.error("DataIntegrityViolationException" );  
       		registrationView.addObject("error", "EmailId.exists"); 
    		return registrationView;   
    	}
    	catch (Exception ex) {
    		logger.error("Error creating the user ");    		
    		registrationView.addObject("error", ex.getMessage()); 
    		ex.printStackTrace();
    		return registrationView; 
    	}		
	    return welcomeView;
	}
	/**
	 * Fetch the Registration page for the user
	 * @param user
	 * @param result
	 * @return
	 */
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("user") User user,
	      BindingResult result) {
	    return new ModelAndView("addUser");
	}	
}
