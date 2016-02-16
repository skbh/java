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
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String userName;
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Vehicles>  vehicles= new ArrayList <Vehicles>();
	
	
	public UserD() {	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Collection<Vehicles> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicles> vehicles) {
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
