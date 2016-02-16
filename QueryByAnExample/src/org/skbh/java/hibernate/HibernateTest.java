package org.skbh.java.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.skbh.java.dto.UserDetail;
public class HibernateTest {

	public static void main(String[] args) {
			
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		UserDetail exampleuser=new UserDetail();
		//exampleuser.setUserId(5);
		exampleuser.setUserName("userName2%");
		Example example=Example.create(exampleuser).enableLike();		
		
		Criteria  criteria=session.createCriteria(UserDetail.class)
						  .add(example);
			
		@SuppressWarnings("unchecked")
		List<UserDetail> users=(List<UserDetail>) criteria.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of users = " + users.size());
		for(UserDetail u : users){
			System.out.println("Id: " + u.getUserId() + "  " +  u.getUserName());
			
		}
			
		
	}

}


