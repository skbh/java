package com.skbh.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {
	@NotEmpty(message="country cant Empty")
	private String country;
	@NotEmpty(message="city cant Empty")
	private String city;
	@NotEmpty(message="street cant Empty")
	private String street;
	@NotNull(message="pincode cant Empty")
	private int pincode;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	

}
