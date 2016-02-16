package org.skbh.java.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "UserDetail.ById", query = "from UserDetail where userId = ?")
// @org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long userId;
	private String userName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long l) {
		this.userId = l;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
