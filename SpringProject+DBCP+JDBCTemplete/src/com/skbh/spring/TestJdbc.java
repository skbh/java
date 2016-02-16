package com.skbh.spring;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skbh.dao.JdbcDaoImpl;
import com.skbh.dao.SimpleJdbcDaoSupportImpl;
import com.skbh.model.Circle;


public class TestJdbc {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdbcDaoImpl=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		Circle circle=jdbcDaoImpl.getCircle(102);
		System.out.println("total Record " + jdbcDaoImpl.CountRecord());
        System.out.println(circle.getName());
        System.out.println(jdbcDaoImpl.getCircleByName("101"));
        System.out.println(jdbcDaoImpl.getCircleById(103).getName());
        //jdbcDaoImpl.insertCircle(new Circle(104,"Circle T-104"));
        //jdbcDaoImpl.deleteCircle(105);
        jdbcDaoImpl.updateCircle(106, "Equilateral T-106");
        Iterator<Circle> it=jdbcDaoImpl.getAllCircle().iterator();
        	while(it.hasNext()){
        		Circle c=(Circle) it.next();
        		System.out.print("Id :" + c.getId());
        		System.out.println(" Name :" + c.getName());
        }// end while
        	SimpleJdbcDaoSupportImpl dao=ctx.getBean("simpleJdbcDaoSupportImpl", SimpleJdbcDaoSupportImpl.class);
        	System.out.println("Total Circle by new dao " + dao.getCountcircle());
        	
	}

}
