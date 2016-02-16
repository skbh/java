package com.skbh.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skbh.Spring.service.ShapeService;

public class AOPMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService=ctx.getBean("shapeService", ShapeService.class);
		//System.out.println(shapeService.getCircle().getName());
		shapeService.getCircle().setName("setName new Circle");
		
		

	}

}
