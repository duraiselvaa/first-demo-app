package com.er.wm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.er.wm.dao.PropertyDao;
import com.er.wm.model.Property;

/**
 * Implmentation of PropertyService, with methods to handle the property objects
 * @author Others
 *
 */
@Service("propertyService")
@Transactional(readOnly = true)
public class PropertyServiceImpl implements PropertyService{
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
	
	@Autowired
	private PropertyDao propertyDao;

	/**
	 * Save the property given
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false) 
	public void addProperty (Property property ) {
		logger.info("adding the property : "+property.getAliasName());
		propertyDao.saveProperty(property);		
	}
	/**
	 * Deletes the given property
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false) 
	public void deleteProperty(String id) {
		propertyDao.deleteProperty(id);
	}
	/**
	 * Updates the property given with the new attributes
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false) 
	public Property updateProperty(Property property) {
		return propertyDao.updateProperty(property);
	}
	/**
	 * Fetch all the properties belonging to the given user 
	 */
	public List<Property> listProperties(String userId) {
		logger.info("listing the properties for the user : "+userId);
		return propertyDao.listProperties(userId);
	}
	/**
	 * Fetch the property associated with the given property ID
	 */
	public  Property getPropertyById(String id) {		
		return propertyDao.getPropertyById(id);
	}
	/**
	 * Fetch the properties matching the criteria in the given property object. User for search.
	 */
	public List<Property> getMatchingPropeties(Property property) {
		return propertyDao.getMatchingProperties(property);
	}	
	/**
	 * Fetch the property with the alias name matching the given alias name
	 */
	public Property getPropertyByName(String aliasName) {
		return propertyDao.getPropertyByName(aliasName);
	}
	/**
	 * Fetch the properties in the given city
	 */
	public Property getPropertyByCity(String city) {
		return propertyDao.getPropertyByCity(city);
	}
	/**
	 * Fetch the properties in the given state
	 */
	public Property getPropertyByStreet(String street) {
		return propertyDao.getPropertyByStreet(street);
	}
}
