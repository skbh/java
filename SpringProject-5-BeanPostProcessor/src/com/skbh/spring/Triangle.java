package com.skbh.spring;



//public class Triangle{
public class Triangle{
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


	public void draw(){
		System.out.println("Triangle type : " + getType());
		System.out.println("Point A = (" + getPointA().getX() + ","  + getPointA().getY() + " )");
		System.out.println("Point B = (" + getPointB().getX() + ","  + getPointB().getY() + " )");
		System.out.println("Point C = (" + getPointC().getX() + ","  + getPointC().getY() + " )");
		
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}




	public void init(){
		System.out.println("My Pojo to initializ fields");this.type="pojo init";
		
	}

	public void cleanup(){
	System.out.println("MY Pojo Clean-up code will come here");this.type=null;
	}

	
}
