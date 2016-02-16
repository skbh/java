package com.skbh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext appcontext=new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape) appcontext.getBean("triangle");
		shape.Draw();

	}

}
