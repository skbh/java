package com.skbh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//instead of User.hbm.xml <id name="username" type="java.lang.String"> <column name="USERNAME" /> <generator class="assigned" /> </id>
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String username;
	private String password;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {

		return "Username=" + username + "password=" + password;
	}

}
