package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.Owner;
import org.skbh.java.dto.Property;

public class HibernateOneToManyTestRead {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction().begin();
		Owner owner = (Owner) session.get(Owner.class, 1);
		for (Property property : owner.getProperties()) {
			System.out.println("Owner Name : " + property.getOwner().getOwnerName());
			System.out.println("Property Address : " + property.getPropertyAddress());
			System.out.println("Property Name : " + property.getPropertyName());
		}

		session.getTransaction().commit();
		session.close();

	}

}
