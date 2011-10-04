package com.er.wm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * User entity mapping with the User table
 * @author Others
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	/* attributes */		

	@Id @GeneratedValue
	@Column(name = "user_id" )	
	private String id;
	
	@Column(name = "email_id" )	
	@NotNull
	private String emailId;
	
	@Column(name = "password" )
	@NotNull
	private String password;
	
	@Transient
	@NotNull
	private String confirmPassword;
	
	@Column(name="type")
	private int type;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Constructor with all the attributes
	 * @param emailId
	 * @param password
	 */
	public User(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	/* A do-nothing constructor */
	public User() {
		
	}	
}