package com.skbh.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skbh.pojo.Robot;

public class GetObjects { 

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Robot robot2=new Robot();
		robot2.setRobotName("test Robofdsdf sdf");
		robot2.setRobotPrice(0d);
		session.saveOrUpdate(robot2);
		session.flush();
		Robot robot=(Robot) session.load("com.skbh.pojo.Robot", 2);
		System.out.println(robot.getRobotId());
		//System.out.println(robot.getRobotName());
		session.close();
	}

}
