package com.er.wm.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.er.wm.model.User;

/**
 * Handles requests for validating the user object
 */
@Component("userValidator")
public class UserValidator implements Validator {
	
	private static final Logger logger = LoggerFactory.getLogger(UserValidator.class);
	
	@Override
	 public boolean supports(Class clazz) {
		 return User.class.isAssignableFrom(clazz);
	 }
	/**
	 * Validates the user id and password entered before creating the user
	 */
	@Override 
	 public void validate(Object model, Errors errors) {
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId","EmailId.required");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.required");		
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","confirmPassword.required");
		 
		 User user = (User) model;
		 
		 if(!isValidEmailAddress(user.getEmailId())) {
			 errors.rejectValue("emailId","EmailId.not.valid");
		 }
		 
		 if(!(user.getPassword().equals(user.getConfirmPassword())))
		 {
			 errors.rejectValue("confirmPassword","password.doesnt.match");
		 }		 
	 }
	
	 public boolean isValidEmailAddress(String emailAddress){  
		   String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
		   CharSequence inputStr = emailAddress;  
		   Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
		   Matcher matcher = pattern.matcher(inputStr);  
		   return matcher.matches();  		  
	 } 
}
