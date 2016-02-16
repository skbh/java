package com.skbh.spring;

public class Triangle {
	private String type;
	private int height;
	
	
	public Triangle(String type) {
		this.type = type;
	}


	public Triangle(int height) {
		super();
		this.height = height;
	}


	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}


	public void draw(){
		System.out.println(getType() + " : Triangle drawn at height of :" + getHeight());
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}

}
