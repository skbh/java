package com.skbh.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoSupportImpl implements Manager{
	
	@Autowired
	private SessionFactory sessionFactory;
		

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public int getCountcircle() {
		Session session=getSessionFactory().openSession();
		Query query=session.createQuery("select count(*) from Circle");
		return  ((Long)query.uniqueResult()).intValue();
	
		
	}


	@Override
	public int getCountcircleByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}


}
