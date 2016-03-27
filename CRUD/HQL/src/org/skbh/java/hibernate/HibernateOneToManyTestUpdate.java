package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.Owner;

public class HibernateOneToManyTestUpdate {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction().begin();
		Owner owner = (Owner) session.get(Owner.class, 2);
		owner.getProperties().get(1).setPropertyAddress("Banglore, India");
		session.update(owner);
		session.getTransaction().commit();
		session.close();

	}

}
