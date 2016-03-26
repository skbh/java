package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.Owner;
import org.skbh.java.dto.Property;

public class HibernateOneToManyTest {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction().begin();
		Owner owner = new Owner();
		Property property1 = new Property();
		Property property2 = new Property();

		owner.setOwnerAddress("New Delhi India");
		owner.setOwnerName("Manisha");

		property1.setOwner(owner);
		property2.setOwner(owner);

		property1.setPropertyAddress("Ranchi India");
		property1.setPropertyName("Bangloo");
		owner.getProperties().add(property1);

		property2.setPropertyAddress("California,United States");
		property2.setPropertyName("villa");
		owner.getProperties().add(property2);

		session.save(owner);

		session.getTransaction().commit();
		session.close();

	}

}
