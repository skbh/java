package com.skbh.model;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class Student {
	@Size(min=10,max=30)
	@NotEmpty(message="studentName cant Empty")
	private String studentName;
	@NotEmpty(message="course cant Empty")
	private String course;
	@NotNull(message="contact cant Empty")
	private long contact;
	
	private Address address;
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull @Past
	private Date dob;
	
	private ArrayList<String> skills;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public ArrayList<String> getSkills() {
		return skills;
	}
	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
		
	
		
}
