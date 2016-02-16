package org.skbh.java.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class UserD {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;
	private String userName;
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Vehicle>  vehicles= new ArrayList <Vehicle>();
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}



}


/*
 * package org.skbh.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserD {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicles vehicle;
	
	public Vehicles getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}



}



 * 
 * 
 * 
 */ 
