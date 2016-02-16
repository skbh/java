package com.skbh.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {
	@Autowired
	@Qualifier("circleRelated")
	private Point center; 
	
	
	@Override
	public void Draw() {
		System.out.println("Drawing Cricle : ( " + getCenter().getX() + " , "+ getCenter().getY() + " )");
		
	}


	public Point getCenter() {
		return center;
	}

	
	public void setCenter(Point center) {
		this.center = center;
	}


}
