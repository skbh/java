package com.skbh.pojo;

import java.io.Serializable;

public class Robot implements Serializable {

	private Integer robotId;
	private String robotName;
	private Double robotPrice;
	
	public Integer getRobotId() {
		return robotId;
	}
	public void setRobotId(Integer robotId) {
		this.robotId = robotId;
	}
	public String getRobotName() {
		return robotName;
	}
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
	public Double getRobotPrice() {
		return robotPrice;
	}
	public void setRobotPrice(Double robotPrice) {
		this.robotPrice = robotPrice;
	}
	
	
		

}
