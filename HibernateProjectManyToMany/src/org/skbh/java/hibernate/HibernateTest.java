package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.UserD;
import org.skbh.java.dto.Vehicles;


public class HibernateTest {

	public static void main(String[] args) {

		UserD user = new UserD();
		user.setUserName("sushil k bhaskar");

		Vehicles vehicle = new Vehicles();
		vehicle.setVechicleName("BMW Car");
		
		Vehicles vehicle2 = new Vehicles();
		vehicle2.setVechicleName("Mercedes Car");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);	
		vehicle.getUserlist().add(user);
		vehicle2.getUserlist().add(user);

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		//session.persist(user);
	  
		session.getTransaction().commit();
		session.close();

	}

}



/*package org.skbh.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.skbh.java.dto.UserD;
import org.skbh.java.dto.Vehicles;


public class HibernateTest {

	public static void main(String[] args) {

		UserD user = new UserD();
		user.setUserName("sushil k bhaskar");

		Vehicles vehicle = new Vehicles();
		vehicle.setVechicleName("BMW Car");
		
		Vehicles vehicle2 = new Vehicles();
		vehicle2.setVechicleName("Mercedes Car");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);	
		vehicle.setUser(user);
		vehicle2.setUser(user);		

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		session.save(user);
	    session.save(vehicle);
	    session.save(vehicle2);
	    

		session.getTransaction().commit();
		session.close();

	}

}


*/






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