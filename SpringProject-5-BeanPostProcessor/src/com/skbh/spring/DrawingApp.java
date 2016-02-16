package com.skbh.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	
	
	public static void main(String[] args) {
		
		AbstractApplicationContext appcontext=new ClassPathXmlApplicationContext("spring.xml");
		appcontext.registerShutdownHook();
		Triangle triangle=(Triangle) appcontext.getBean("triangle-name");
		triangle.draw();
		appcontext.close();
	}

}
