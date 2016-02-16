package org.skbh.java.dto;

import java.util.ArrayList;
import java.util.Collection;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicles {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vechicleName;
	
	@ManyToMany(mappedBy="vehicles")
	private Collection<UserD> userlist=new ArrayList<UserD>(); 
	
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
		
	public Collection<UserD> getUserlist() {
		return userlist;
	}
	public void setUserlist(Collection<UserD> userlist) {
		this.userlist = userlist;
	}
	public Vehicles() {			}
	

}
