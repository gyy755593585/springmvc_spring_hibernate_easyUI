/**
 * WUJI CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: WUJI
 *
 * Copyright © 2017 WUJI Corporation. All rights reserved.
 */
package com.wuji.demo.integration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	private String username;

	private String password;

	/**
	 * Get the value of or reference to id.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Assign the value of id to id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get the value of or reference to username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Assign the value of username to username.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the value of or reference to password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Assign the value of password to password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public String toString() {
		return "User [id=" + this.id + ", username=" + this.username + ", password=" + this.password + "]";
	}

}
