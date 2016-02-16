package com.skbh.spring;

public class Triangle implements Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private String type;
	
	

	public Point getPointA() {
		return pointA;
	}


	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public Point getPointB() {
		return pointB;
	}


	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	public Point getPointC() {
		return pointC;
	}


	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public void Draw() {
		System.out.println("Triangle type : " + getType());
		System.out.println("Point A = (" + getPointA().getX() + ","  + getPointA().getY() + " )");
		System.out.println("Point B = (" + getPointB().getX() + ","  + getPointB().getY() + " )");
		System.out.println("Point C = (" + getPointC().getX() + ","  + getPointC().getY() + " )");
		
		
	}


	

	
}
