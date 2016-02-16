package com.calculator;

public class Calculator {

	public int add(int... numbers){
		int sum=0;
		for(int get:numbers){
			sum+=get;
		}
		return sum;
	}
	
	public int mult(int... numbers){
		int mult=1;
		for(int get:numbers){
			mult*=get;
		}
		return mult;
	}
	
	public int lengthOfString(String data){
		return data.length();
	}
}
