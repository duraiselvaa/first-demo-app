/**
 * 
 */
package com.er.wm.controllers;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


/**
 * Test class for the HomeController.
 * @author Others
 */
public class HomeControllerTest extends TestCase {
	/**
	 * Test case for the home method
	 * @throws Exception
	 */
	@Test
	 public void testGetHomePage() throws Exception{      
        HomeController controller = new HomeController();
        /* We don't have to pass any valid values here because all it does is to send the user to the home page*/
        ModelAndView modelAndView = controller.getHomePage(null, null, null);  
        assertEquals("home", modelAndView.getViewName());
    }

}
