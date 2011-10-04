package com.er.wm.dao;

import java.util.List;

import com.er.wm.model.Property;

public interface PropertyDao {

	  public void saveProperty (Property property );
	  
	  public void deleteProperty (String id);
	  
	  public Property updateProperty (Property property);
	  
	  public List<Property> listProperties(String userId);
	  
	  public Property getPropertyById (String id);
	  
	  public List<Property> getMatchingProperties (Property property);
	  
	  public Property getPropertyByName(String aliasName);
	  
	  public Property getPropertyByCity(String city);
	  
	  public Property getPropertyByStreet(String city);
	  
	}
