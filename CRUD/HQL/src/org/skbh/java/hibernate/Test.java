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
		UserDetail user = (UserDetail) session.load(UserDetail.class, 2);
		System.out.println("class Name " + user.getClass());
		session.getTransaction().commit();
		session.close();
		UserDetail user1 = new UserDetail();
		user1.setUserId(2);
		user1.setUserName("Merge session");
		session = sessionfactory.openSession();
		session.beginTransaction();
		session.merge(user1);
		user1.setUserName("Merge session obj");

		session.getTransaction().commit();
		session.close();

	}

}
