package org.skbh.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="UserDetail.ById",query="from UserDetail where userId = ?")
@NamedNativeQuery(name="UserDetail.Byname", query="select * from UserDetail where userName = ? ", resultClass=UserDetail.class)
//@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetail {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;
	private String userName;
	
	
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


