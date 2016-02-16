package com.skbh.spring;

import java.util.List;

public class Triangle {
	private List<Point> points;
	private String type;

		

	public List<Point> getPoints() {
		return points;
	}


	public void setPoints(List<Point> points) {
		this.points = points;
	}


	public void draw(){
		System.out.println("Triangle type : " + getType());
		for(Point point : points){
			System.out.println("Point A = (" +  point.getX() + ","  + point.getY() + " )");	
		}
		
		
		
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	

	
}
