package org.skbh.java.dto;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}

	
}
