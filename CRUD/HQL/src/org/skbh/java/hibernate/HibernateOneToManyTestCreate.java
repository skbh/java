package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.Address;
import org.skbh.java.dto.Owner;
import org.skbh.java.dto.Property;

public class HibernateOneToManyTestCreate {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Owner owner = new Owner();
		Property property1 = new Property();
		Property property2 = new Property();
		Address address = new Address();
		address.setAddress("3rd floor, Room NO 304");
		address.setCity("new delhi");
		address.setCountry("India");
		address.setPincode("310001");
		address.setState("new delhi");
		owner.setOwnerName("sushil kumar bhaskar");

		Address address2 = new Address();
		address2.setAddress("2nd floor, Room NO 102");
		address2.setCity("Bokaro");
		address2.setCountry("new Delhi");
		address2.setPincode("82804");
		address2.setState("Jharkhand");

		owner.getAddress().add(address);
		owner.getAddress().add(address2);

		property1.setOwner(owner);
		property2.setOwner(owner);

		property1.setPropertyAddress("New Delhi,India");
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
