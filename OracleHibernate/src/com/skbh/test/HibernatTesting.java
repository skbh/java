package com.skbh.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.skbh.pojo.Robot;

public class HibernatTesting {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Robot robot=new Robot();
		robot.setRobotName("Optimus Prime");
		robot.setRobotPrice(787888d);
		session.save(robot);
		tx.commit();
		
	}

}
