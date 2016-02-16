package org.skbh.java.dto;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
public class FourWheeler extends Vehicle {
     private String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}

}
