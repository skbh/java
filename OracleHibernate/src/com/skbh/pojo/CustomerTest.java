package com.skbh.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction().begin();
	/*	Customer customer=new Customer();
		CustOrder custOrder1=new CustOrder();
		CustOrder custOrder2=new CustOrder();
		CustOrder custOrder3=new CustOrder();
		List<CustOrder> custOrders = new ArrayList<CustOrder>();
		Random rand=new Random(100);
		rand.nextInt();
		custOrder1.setCustnumber("Nokia " + rand.nextInt());
		custOrder1.setCustomer(customer);
		custOrder2.setCustnumber("Samsung " + rand.nextInt());
		custOrder2.setCustomer(customer);
		custOrder3.setCustnumber("HTC " + rand.nextInt());
		custOrder3.setCustomer(customer);
		custOrders.add(custOrder1);
		custOrders.add(custOrder2);
		custOrders.add(custOrder3);
		customer.setOrders(custOrders);
		session.save(customer);		
		session.getTransaction().commit();*/
		session.beginTransaction().begin();
		Customer lazyCustObj=session.load(Customer.class, 17);
		System.out.println("Customer Id: "+ lazyCustObj.getId());
		System.out.println("Customer size data: "+ lazyCustObj.getOrders().size());
		
		session.getTransaction().commit();
		session.close();

	}

}
