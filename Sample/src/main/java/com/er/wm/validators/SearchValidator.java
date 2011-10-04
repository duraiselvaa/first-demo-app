package com.er.wm.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.er.wm.model.Property;
import com.er.wm.model.User;

/**
 * Handles requests for the application home page.
 */
@Component("searchValidator")
public class SearchValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchValidator.class);
	
	@Override
	 public boolean supports(Class clazz) {
		 return Property.class.isAssignableFrom(clazz);
	 }
	/**
	 * Validate if the search critera are entered correctly
	 */
	@Override 
	 public void validate(Object model, Errors errors) {
		 Property property = (Property) model;
		 
		 if((property.getCity() == null) && (property.getStreet() == null)) {
			 errors.rejectValue("enterSearchTerms","search.fields.empty");
		 }
	 }
}
