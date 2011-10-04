package com.er.wm.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.er.wm.model.Property;

/**
 * Handles requests for validating the property object
 */
@Component("propertyValidator")
public class PropertyValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyValidator.class);
	
	@Override
	 public boolean supports(Class clazz) {
		 return Property.class.isAssignableFrom(clazz);
	 }
	/**
	 * Validates the property attributes entered before creating a new property
	 */
	@Override 
	 public void validate(Object model, Errors errors) {
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aliasName","Alias.required");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street","street.required");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city","city.required");
	 }
}
