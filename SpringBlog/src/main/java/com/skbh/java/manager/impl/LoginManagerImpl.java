package com.skbh.java.manager.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.skbh.java.manager.LoginManager;
import com.skbh.java.model.LoginDetails;

public class LoginManagerImpl implements LoginManager {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean registerUser(LoginDetails logindetails) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(logindetails);
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			tx.rollback();
			return false;
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

}
