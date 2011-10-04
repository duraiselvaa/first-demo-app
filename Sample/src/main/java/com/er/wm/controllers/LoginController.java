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
import com.er.wm.model.Property;
import com.er.wm.service.UserService;

/**
 * Handles requests related to logging in and out
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * Method which fetch the login page for the user
	 * @param user
	 * @param result
	 * @return login view
	 */
	
	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@ModelAttribute("user") User  user,
		      BindingResult result) {
	    return new ModelAndView("login");
	}
	
	/**
	 * Method which validates the login info entered
	 * @param user
	 * @param session
	 * @return welcome page if successful, or the same login page with error message if login failed
	 */
	
	@RequestMapping(value = "/log", method = RequestMethod.POST)	
	public ModelAndView login(User user, HttpSession session) {	    
		try {
			User usr = userService.getUser(user.getEmailId(), user.getPassword());
			logger.info("fetched user : "+usr);
			if(usr ==null) {
				logger.info("user name or password is wrong");
				ModelAndView loginView = new  ModelAndView("login");
				loginView.addObject("error", "Either the emailId or the Password or both are wrong");
				return loginView;
			}
			session.setAttribute("user_id", usr.getId());
			session.setAttribute("user_email", usr.getEmailId());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	    return new ModelAndView("welcome");
	}
	
	/**
	 * Logs the user out from the website
	 * @param user
	 * @param session
	 * @return redirects to the home page with the message
	 */
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)	
	public ModelAndView logout(User user, Property property, HttpSession session) {	    
		logger.info("logging out the user "+ user.getEmailId());
			
		session.removeAttribute("user_id");
		session.removeAttribute("user_email");
		
		/* Invalidate the session for security reasons */
		session.invalidate();
			
        ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", "logout.ok");    
		return modelAndView;			
	}	

}
