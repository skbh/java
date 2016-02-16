package com.skbh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	public static void main(String[] args) {
		//Triangle triangle=new Triangle();
		//Type 1
		//BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		@SuppressWarnings("resource")
		ApplicationContext appcontext=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) appcontext.getBean("triangle");
		triangle.draw();

	}

}
