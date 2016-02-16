/*
 * @Programmer sushil kumar bhaskar JSR 1.0 skbh 
 * @Auther ${Programmer_Name}
 * @Project Name Dynamic Method Invocation
 * @File Name CalculatorAction.java
 * 
 */
package com.simplecode.action;

import com.opensymphony.xwork2.Action;

public class CalculatorAction implements Action {
	private float number1;
	private float number2;
	private float result;
	private String methodName;
	private String userName;

	@Override
	public String execute() {
		number1 = 0;
		number2 = 0;
		result = 0;
		setMethodName("execute Method");
		return SUCCESS;
	}

	public String display() {
		setMethodName("userName");
		return "json";
	}

	public String add() {
		result = number1 + number2;
		setMethodName("add Method");
		return SUCCESS;
	}

	public String subtract() {
		result = number1 - number2;
		setMethodName("subtract Method");
		return SUCCESS;
	}

	public String multiply() {
		result = number1 * number2;
		setMethodName("multiply Method");
		return SUCCESS;
	}

	public String divide() {
		if (number2 != 0)
			result = number1 / number2;
		else if (number1 != 0)
			result = number2 / number1;
		else
			result = 0;

		setMethodName("divide Method");
		return SUCCESS;
	}

	public float getNumber1() {
		return number1;
	}

	public void setNumber1(float number1) {
		this.number1 = number1;
	}

	public float getNumber2() {
		return number2;
	}

	public void setNumber2(float number2) {
		this.number2 = number2;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}