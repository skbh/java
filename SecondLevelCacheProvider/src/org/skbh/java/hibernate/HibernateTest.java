package org.skbh.java.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.UserDetail;
public class HibernateTest {

	public static void main(String[] args) {
			
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		UserDetail user=(UserDetail) session.get(UserDetail.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		Session session1=sessionfactory.openSession();
		session1.beginTransaction();
		UserDetail user2=(UserDetail) session1.get(UserDetail.class, 1);
		session1.getTransaction().commit();
		session1.close();
		
		
		
		
		
			
		
	}

}


