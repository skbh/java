package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.Owner;

public class HibernateOneToManyTestDelete {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction().begin();
		Owner owner = (Owner) session.get(Owner.class, 1);
		session.delete(owner);
		session.getTransaction().commit();
		session.close();

	}

}
