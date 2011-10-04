package com.er.wm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Propert entity mapping with the property table.
 * @author Others
 *
 */
@Entity
@Table(name = "property")
public class Property {
	
	/* attributes */	

	@Id @GeneratedValue
	@Column(name = "Property_id" )	
	private String id;
	
	@Column(name = "alias_name" )		
	private String aliasName;
	
	@Column(name = "street" )	
	private String street;
	
	@Column(name = "city" )	
	private String city;
	
	@Column(name="user_id")
	private String userId;
	
	/*
	 * Getter and setter methods
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * Constructor with all the property attributes
	 * @param aliasName
	 * @param street
	 * @param city
	 * @param userId
	 */
	public Property(String aliasName, String street, String city, String userId) {		
		this.aliasName = aliasName;
		this.street = street;
		this.city = city;
		this.userId = userId;
	}

	/* A do-nothing constructor */
	public Property() {
		
	}	
}	
