package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.UserDetail;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		UserDetail user = (UserDetail) session.get(UserDetail.class, 4);
		System.out.println("class Name " + user.getClass());
		session.getTransaction().commit();
		session.close();
		user.setUserName("new XORASYSGEN");
		session = sessionfactory.openSession();
		session.beginTransaction();
		session.merge(user);

		session.getTransaction().commit();
		session.close();
		System.out.println("User Id " + user.getUserName());

	}

}
