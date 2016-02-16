package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.Address;
import org.skbh.java.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
	
		UserDetails user=new UserDetails();
		user.setUserName("first User NAme");
			
		Address addr1=new Address();
		addr1.setCity("New Delhi");
		addr1.setPincode("110025");
		addr1.setState("New Delhi-India");
		addr1.setStreet("Sarai Jullena");
		user.getListOfAddress().add(addr1);
		
		
		Address addr2=new Address();
		addr2.setCity("Noida");
		addr2.setPincode("120458");
		addr2.setState("NCR-India");
		addr2.setStreet("Sector 125");
		user.getListOfAddress().add(addr2);
				
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.persist(user);
		addr2.setStreet("Sector 1");
		addr2.setStreet("Sector 12");
		
		
		session.getTransaction().commit();
		session.close();
		
		session=sessionfactory.openSession();
		user=(UserDetails) session.get(UserDetails.class,1);
		session.close();
		System.out.println(user.getListOfAddress().size());
		System.out.println(user.getListOfAddress().contains("new delhi"));
		
				
	
	}

}









/*   
package org.skbh.java.hibernate;
 

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.Address;
import org.skbh.java.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
	
		UserDetails user=new UserDetails();
		UserDetails user2=new UserDetails();
		
				
		user.setUserName("first User");
		user.setJoinedDate(new Date());
		user.setDescription("Somthing For first");
		Address addr=new Address();
		addr.setCity("New Delhi");
		addr.setPincode("110025");
		addr.setState("New Delhi-India");
		addr.setStreet("Sarai Jullena");
		user.setHome_address(addr);
		
		
		Address addr2=new Address();
		addr2.setCity("Noida");
		addr2.setPincode("120458");
		addr2.setState("NCR-India");
		addr2.setStreet("Sector 125");
		
		user.setOffice_address(addr2);		
		
		//User 2
		
		user2.setUserName("User");
		user2.setJoinedDate(new Date());
		user2.setDescription("Somthing For second");
		Address addr3=new Address();
		addr3.setCity("Gurgaon");
		addr3.setPincode("15455");
		addr3.setState("Gurgaon-India");
		addr3.setStreet("Sarai Jullena");
		user2.setHome_address(addr3);
		
		
		Address addr4=new Address();
		addr4.setCity("Noida");
		addr4.setPincode("120458");
		addr4.setState("NCR-India");
		addr4.setStreet("Sector 125");
		
		user2.setOffice_address(addr4);
		
		
		SessionFactory sesionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sesionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		user=null;
	    session=sesionfactory.openSession();
		session.beginTransaction();
		user=(UserDetails) session.get(UserDetails.class, 1);
		System.out.println("user details retrived desc : " + user.getDescription());
		System.out.println("user details retrived ADD : " + user.getHome_address());
		System.out.println("user details retrived ADD : " + user.getOffice_address());
		
		System.out.println("user details retrived id : " + user.getUserId());
		
		
		
	}

}

*/