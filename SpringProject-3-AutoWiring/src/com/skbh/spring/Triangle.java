package com.skbh.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class Triangle  implements ApplicationContextAware ,BeanNameAware{
	
		private Point pointA;
		private Point pointB;
		private Point pointC;
		private String type;
		private ApplicationContext context=null;
		private String beanname;
		
	
		public Point getPointA() {
			return pointA;
		}


		public void setPointA(Point pointA) {
			this.pointA = pointA;
		}



		public Point getPointB() {
			return pointB;
		}



		public void setPointB(Point pointB) {
			this.pointB = pointB;
		}


		public Point getPointC() {
			return pointC;
		}


		public void setPointC(Point pointC) {
			this.pointC = pointC;
		}



		public void draw(){
			System.out.println("Triangle type : " + getType());
			System.out.println("Point A = (" + getPointA().getX() + ","  + getPointA().getY() + " )");
			System.out.println("Point B = (" + getPointB().getX() + ","  + getPointB().getY() + " )");
			System.out.println("Point C = (" + getPointC().getX() + ","  + getPointC().getY() + " )");
			System.out.println("application Context name : " + getContext().getDisplayName().toString());
			System.out.println("application Bean Name : " + getBeanname()); 
			
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		@Override
		public void setApplicationContext(ApplicationContext context)
				throws BeansException {
			this.context = context;
			
		}


		public ApplicationContext getContext() {
			return context;
		}


		public void setContext(ApplicationContext context) {
			this.context = context;
		}


		@Override
		public void setBeanName(String beanname) {
			System.out.println("BeanNameAware called " + beanname);
			this.beanname = beanname;
			
		}


		public String getBeanname() {
			return beanname;
		}


		public void setBeanname(String beanname) {
			this.beanname = beanname;
		}


	
}
