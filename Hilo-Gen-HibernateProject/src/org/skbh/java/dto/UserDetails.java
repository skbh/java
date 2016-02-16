package org.skbh.java.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table (name="UserDetail") 
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	//@Transient if we want to hide 
	private String userName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="UserDetail_Address")
	private Collection<Address> ListOfAddress=new ArrayList<Address>() ;
	
	public Collection<Address> getListOfAddress() {
		return ListOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		ListOfAddress = listOfAddress;
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





/* Home address and office address 
  
package org.skbh.java.dto;
 

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table (name="USER") 
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Transient 
	private String userName;
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street" , column = @Column(name = "Home_Street_Name")),
	@AttributeOverride(name="city" , column = @Column(name = "Home_City_Name")),
	@AttributeOverride(name="pincode" , column = @Column(name = "Home_Pin_Code")),	
	@AttributeOverride(name="state" , column = @Column(name = "Home_State_Name")),
	})
	private Address home_address;
	
	@Embedded
	private Address office_address;
	@Lob
	private String description;
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public Address getHome_address() {
		return home_address;
	}
	public void setHome_address(Address home_address) {
		this.home_address = home_address;
	}
	public Address getOffice_address() {
		return office_address;
	}
	public void setOffice_address(Address office_address) {
		this.office_address = office_address;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
		
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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


*/