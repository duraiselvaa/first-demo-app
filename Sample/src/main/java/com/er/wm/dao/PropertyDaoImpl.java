package com.er.wm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.er.wm.model.Property;

/**
 * Implementation of PropertyDao, with method to help with the CRUD operation for properties
 * @author Others
 */

@Repository("propertyDao")
public class PropertyDaoImpl implements PropertyDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Save the given property
	 */
	public void saveProperty (Property property ) {
		sessionFactory.getCurrentSession().saveOrUpdate(property);		
	}
	
	/**
	 * Deletes the given property
	 */	
	public void deleteProperty (String id) {
		Property property = getPropertyById(id);
		sessionFactory.getCurrentSession().delete(property);
	}
	
	/**
	 * Updates the given property with new values
	 */	
	public Property updateProperty (Property property) {
	  return (Property) sessionFactory.getCurrentSession().merge(property);
	}

	/**
	 * Fetch all the properties belonging to the gievn user
	 */
	public List<Property> listProperties(String userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Property where user_id = :userId ");
		query.setParameter("userId", userId);
		@SuppressWarnings("unchecked")
		List<Property> list = query.list();
		return list;
	}
	/**
	 * Fetch the property associated with the given property ID
	 */
	public Property getPropertyById(String propertyId) {
		Property property = (Property) sessionFactory.getCurrentSession().get(Property.class, propertyId);
		return property;
	}
	/**
	 * Fetch the properties matching the criteria in the given property object. User for search.
	 */
	@SuppressWarnings("unchecked")
	public List<Property> getMatchingProperties(Property property) {		
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Property.class);		 
		 criteria.add(Restrictions.ilike("street", "%"+(property.getStreet() == null?"":property.getStreet())+"%"));
		 criteria.add(Restrictions.ilike("city", "%"+property.getCity()+"%"));
		 return criteria.list();		
	}	
	/**
	 * Fetch the property with the alias name matching the given alias name
	 */
	public Property getPropertyByName(String aliasName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Property.class);
		criteria.add(Restrictions.eq("aliasName", aliasName));
		Property property = (Property) criteria.uniqueResult();
		return property;
	}

	/**
	 * Fetch the properties in the given city
	 */
	public Property getPropertyByCity(String city) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Property.class);
		criteria.add(Restrictions.eq("city", city));
		Property property = (Property) criteria.uniqueResult();
		return property;
	}
	/**
	 * Fetch the properties in the given state
	 */
	public Property getPropertyByStreet(String street) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Property.class);
		criteria.add(Restrictions.eq("street", street));
		Property property = (Property) criteria.uniqueResult();
		return property;
	}

}
