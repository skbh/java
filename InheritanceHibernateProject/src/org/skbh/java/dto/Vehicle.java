package org.skbh.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
@Inheritance(strategy=InheritanceType.JOINED)//fully normalized
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//medium normalized
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//low normalized
//@DiscriminatorColumn(name="VEHICLE_TYPE",discriminatorType=DiscriminatorType.STRING)
public class Vehicle {
	@Id
	@GeneratedValue(strategy =GenerationType.TABLE)
	private int vehicleId;
	private String vechicleName;
	
		public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVechicleName() {
		return vechicleName;
	}
	public void setVechicleName(String vechicleName) {
		this.vechicleName = vechicleName;
	}	

}
