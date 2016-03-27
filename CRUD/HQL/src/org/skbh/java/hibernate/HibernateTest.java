package org.skbh.java.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.UserDetail;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String MinUserId = "1";
		String userName = "sushil";
		// Query query=session.createQuery("from UserDetail where userId > ? and
		// userName= ?");
		// query.setInteger(0, Integer.parseInt(MinUserId));
		// query.setString(1, userName);

		// its parameter binding so that sql injection could`nt happen
		Query query = session.createQuery("from UserDetail where userId > :userid and userName= :username");
		query.setInteger("userid", Integer.parseInt(MinUserId));
		query.setString("username", userName);
		@SuppressWarnings("unchecked")
		List<UserDetail> users = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of users = " + users.size());
		for (UserDetail u : users) {
			System.out.println("Id: " + u.getUserId() + "  " + u.getUserName());

		}

	}
}
