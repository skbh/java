package org.skbh.java.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column (name="Street_Name")
	private String street;
	
	@Column (name="City_Name")
	private String city;
	
	@Column (name="State_Name")
	private String state;
	
	@Column (name="Pin_Code")
	private String pincode;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
