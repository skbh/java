package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.UserDetail;
public class HibernateTest {

	public static void main(String[] args) {
		UserDetail user=new UserDetail();
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
			
		user=(UserDetail)session.get(UserDetail.class,1);
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("new user updated");
		
		session=sessionfactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		user.setUserName("again new user updated");
		session.getTransaction().commit();
		session.close();
		
		
		
	}
}


