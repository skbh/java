/*
 * @Programmer sushil kumar bhaskar JSR 1.0 skbh 
 */
package com.skbh.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class HibernateTemplete.
 */
@Repository
public class HibernateTempleteClass implements Manager {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session factory.
	 * 
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 * 
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skbh.dao.Manager#getCountcircle()
	 */
	@Override
	public int getCountcircle() {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("select count(*) from Circle");
		return ((Long) query.uniqueResult()).intValue();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skbh.dao.Manager#getCountcircleByName(java.lang.String)
	 */
	@Override
	public int getCountcircleByName(String name) {
		Session session = getSessionFactory().openSession();
		Query query = session
				.createQuery("select count(*) from Circle where name=?");
		query.setString(0, name);
		return ((Long) query.uniqueResult()).intValue();
	}

}
