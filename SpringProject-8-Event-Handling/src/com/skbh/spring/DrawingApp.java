package com.skbh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape) context.getBean("circle");
		shape.Draw();
		
	}

}
