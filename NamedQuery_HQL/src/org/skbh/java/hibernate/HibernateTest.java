package org.skbh.java.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.skbh.java.dto.UserDetail;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("SELECT * FROM userdetail")
				.addEntity(UserDetail.class);
		List<UserDetail> empData = query.list();
		for (UserDetail userDetail1 : empData) {
			// emp.setUserId(Long.parseLong(row[0].toString()));
			// emp.setUserName(row[1].toString());
			System.out.println(userDetail1.getUserId());
			System.out.println(userDetail1.getUserName());
		}

		// Criteria criteria=session.createCriteria(UserDetail.class)
		// .setProjection(Projections.property("userId"));

		// Criteria criteria=session.createCriteria(UserDetail.class)
		// .setProjection(Projections.count("userId"));//property,max,min,count
		// etc
		Criteria criteria = session.createCriteria(UserDetail.class).addOrder(
				Order.desc("userId"));

		// criteria.add(Restrictions.eq("userName", "userName10"))
		// .add(Restrictions.gt("userId", 5));
		// criteria.add(Restrictions.like("userName", "%userName1%"))
		// .add(Restrictions.between("userId", 1, 20));
		// criteria.add(Restrictions.or(Restrictions.between("userId", 5, 7),
		// Restrictions.between("userId", 14, 19)));

		@SuppressWarnings("unchecked")
		List<UserDetail> users = criteria.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of users = " + users.size());
		for (UserDetail u : users) {
			System.out.println("Id: " + u.getUserId() + "  " + u.getUserName());

		}

	}
}
