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
			
		//Query query=session.getNamedQuery("UserDetail.ById");
		Query query=session.getNamedQuery("UserDetail.Byname");
		query.setString(0, "userName14");		
		@SuppressWarnings("unchecked")
		List<UserDetail> users=(List<UserDetail>) query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of users = " + users.size());
		for(UserDetail u : users){
			System.out.println("Id: " + u.getUserId() + "  " +  u.getUserName());
			
		}
			
		
	}
}


