package com.er.wm.controllers;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


/**
 * Test class for the LoginController.
 * @author Others
 */
public class LoginControllerTest extends TestCase {	
	/**
	 * Test case for the getLoginPage method
	 * @throws Exception
	 */
	@Test
	 public void testgetLoginPage() throws Exception {
		LoginController loginController = new LoginController();
         /* We don't have to pass any valid values here because all it does is to send the user to the login page*/
        ModelAndView modelAndView = loginController.getLoginPage(null, null);  
        assertEquals("login", modelAndView.getViewName());
    }
}
