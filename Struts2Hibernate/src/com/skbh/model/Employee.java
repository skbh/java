package com.skbh.model;

public class Employee {
	private String eid;
	private String name;
	private String city;
	private double salary;
	
	public Employee() {  }
	
	  public Employee(String eid, String name, String city, double salary) {
	    this.eid = eid;
	    this.name = name;
	    this.city = city;
	    this.salary = salary;
	  }
	
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return eid + " " + name + " " + city + " " + salary;
		
	}
	
	

}
