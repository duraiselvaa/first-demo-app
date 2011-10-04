package com.er.wm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.er.wm.model.Property;
import com.er.wm.service.PropertyService;
import com.er.wm.validators.PropertyValidator;
import com.er.wm.validators.SearchValidator;

/**
 * Handles requests for the Property CRUD operations
 */
@Controller
@RequestMapping("/property")
public class PropertyController {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private PropertyValidator validator;	
	
	@Autowired
	private SearchValidator searchValidator;
	
	/**
	 * Method to save the property to DS
	 * @param property
	 * @param result
	 * @param session
	 * @return property List view with all the properties belongs to this user
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveProperty(Property property, BindingResult result, HttpSession session) {
		logger.info("Adding a new property "+ property.getAliasName());
		logger.info("session.getAttribute(user_id)"+session.getAttribute("user_id"));
		
		
		validator.validate(property, result);
		if (result.hasErrors()) {
			return new ModelAndView("addProperty");
		}
		
		try {
			property.setUserId((String)session.getAttribute("user_id"));
			propertyService.addProperty(property);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		/* forwarding the user to the propertylist page*/
		
		ModelAndView propertyListView = new ModelAndView("propertyList"); 
		String userId = (String)session.getAttribute("user_id");
		List<Property> list = propertyService.listProperties(userId);		
		propertyListView.addObject("propertylist", list);
		
	    return propertyListView;
	}
	
	/**
	 * Method which deletes the property from DS
	 * @param id, ID of the property to be deleted
	 * @param session
	 * @return property List view with all the properties belongs to this user
	 */
	 @RequestMapping("/delete")
	 public ModelAndView delete(@RequestParam("id")String id, HttpSession session) {
		 logger.info("property id to be deleted "+id);
		 logger.info("session.getAttribute(user_id)"+session.getAttribute("user_id"));		 
		 
		 /* deleting the property selected */
		 
		 propertyService.deleteProperty(id);

		 /* Fetching the property list associated wiht the current user*/
		 
		 String userId = (String)session.getAttribute("user_id");		 
		 List<Property> list = propertyService.listProperties(userId);
		 
		 /* Forwarding the user to the property list page */
		 ModelAndView propertyListView = new ModelAndView("propertyList");		 
		 propertyListView.addObject("propertylist", list);		 
		 propertyListView.addObject("message", "Property Deleted successfully");
	 	 return propertyListView;
	}	
	
	/**
	 * Method which fetch the AddProperty view for the user
	 * @param property
	 * @param result
	 * @return
	 */
	 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addProperty(@ModelAttribute("property") Property  property,
	      BindingResult result) {
		/* forwarding the user the add property page*/
	    return new ModelAndView("addProperty");
	}
	
	/**
	 * Method which fetch the EditProperty view for the user
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editProperty(@RequestParam("id")String id) {		
		ModelAndView editPropertyView = new ModelAndView("editProperty");
		Property property = propertyService.getPropertyById(id);
		editPropertyView.addObject("property", property);
		return editPropertyView;
	}	
	
	/**
	 * Method which updates the selected property details
	 * @param property
	 * @param result
	 * @param session
	 * @return property List view with all the properties belongs to this user
	 */
	 @RequestMapping(value="/update", method=RequestMethod.POST)
	 public ModelAndView updateProperty(@ModelAttribute("property") Property property, BindingResult result, HttpSession session) {
		 
		validator.validate(property, result);
		if (result.hasErrors()) {
			return new ModelAndView("editProperty");
		}
		 
		 logger.info("session.getAttribute(user_id)"+session.getAttribute("user_id"));	
		 
		 String userId = (String)session.getAttribute("user_id");
		 property.setUserId(userId);
		 
		 /* call the update method of property service */
		 Property updatedProperty = propertyService.updateProperty(property);
		 		 
		 /* Get the list with the updated property details for display */
		 ModelAndView propertyListView = new ModelAndView("propertyList");		 		 
		 List<Property> list = propertyService.listProperties(userId);		
		 propertyListView.addObject("propertylist", list);
		 
		 /* add the message about the successful update */
		 propertyListView.addObject("message", "Details of for the property"+updatedProperty.getAliasName()+" updated successfully");
	 	 return propertyListView;
	 }	
	
	 /**
	  * Method which returns all the properties added by this user to the system
	  * @param property
	  * @param model
	  * @param session
	  * @return property List view with all the properties belongs to this user
	  */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listProperties(Property property, Model model, HttpSession session) {
		logger.info("session.getAttribute(user_id)"+session.getAttribute("user_id"));
		
		ModelAndView propertyListView = new ModelAndView("propertyList"); 
		String userId = (String)session.getAttribute("user_id");
		List<Property> list = propertyService.listProperties(userId);		
		propertyListView.addObject("propertylist", list);		
	    return propertyListView;
	}	
	
	/**
	 * Method to fetch the search page
	 * @param property
	 * @param model
	 * @param session
	 * @return Search page
	 */
	@RequestMapping(value = "/getSearch", method = RequestMethod.GET)
	public ModelAndView getSearchPage(Property property, Model model, HttpSession session) {		
		ModelAndView searchView = new ModelAndView("search"); 
	    return searchView;
	}		
	
	/**
	 * Method to search the properties which matches the criteria entered
	 * @param property
	 * @param result
	 * @param session
	 * @return search page if search terms are missing/wrong, or the search results page
	 */
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(Property property, BindingResult result, HttpSession session) {
		logger.error("Searching for Property : "+property.getStreet()+" : "+property.getCity());
		logger.error("session.getAttribute(user_id)"+session.getAttribute("user_id"));
		System.out.println("Searching for Property : "+property.getStreet()+" : "+property.getCity());
		searchValidator.validate(property, result);
		if (result.hasErrors()) {
			return new ModelAndView("search");
		}		
		
		ModelAndView searchResultsView = new ModelAndView("searchResults"); 
		List<Property> list = propertyService.getMatchingPropeties(property);
		searchResultsView.addObject("propertylist", list);
	    return searchResultsView;
	}		
	
	/**
	 * Redirect the user the welcome page
	 * @param property
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView backToWelcomePage(@ModelAttribute("property") Property  property,
	      BindingResult result) {
	    return new ModelAndView("welcome");
	}	
	
}