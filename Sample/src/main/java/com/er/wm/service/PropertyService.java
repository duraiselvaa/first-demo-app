package com.er.wm.service;

import java.util.List;

import com.er.wm.model.Property;

public interface PropertyService {
	
	  public void addProperty(Property property);
	  
	  public void deleteProperty(String id);
	  
	  public Property updateProperty(Property property);

	  public List<Property> listProperties(String userId);
	  
	  public List<Property> getMatchingPropeties(Property userId);	  
	  
	  public Property getPropertyById(String id);
	  
	  public Property getPropertyByName(String aliasName);
	  
	  public Property getPropertyByCity(String city);
	  
	  public Property getPropertyByStreet(String city);

}
