/*
 * 
 */
package com.skbh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skbh.dao.HibernateDaoSupportImpl;
import com.skbh.dao.HibernateTempleteClass;

// TODO: Auto-generated Javadoc
/**
 * The Class HibernateTest.
 */
public class HibernateTest {

	/**
	 * The main method.
	 * 
	 * @param arg
	 *            the arguments
	 */
	@SuppressWarnings("resource")
	public static void main(String[] arg) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		HibernateDaoSupportImpl dao = ctx.getBean("hibernateDaoSupportImpl",
				HibernateDaoSupportImpl.class);
		HibernateTempleteClass dao1 = ctx.getBean("hibernateTempleteClass",
				HibernateTempleteClass.class);
		System.out.println("Total Record in circle " + dao.getCountcircle());
		System.out.println("Total Record in circle "
				+ dao1.getCountcircleByName("Triangle"));

	}
}

/*
 * @Programmer sushil kumar bhaskar JSR 1.0 skbh
 * 
 * package com.skbh.dao;
 * 
 * import org.hibernate.Query; import org.hibernate.Session; import
 * org.hibernate.SessionFactory; import
 * org.springframework.orm.hibernate3.HibernateTemplate; import
 * org.springframework.stereotype.Repository;
 * 
 * // TODO: Auto-generated Javadoc
 *//**
 * The Class HibernateTemplete.
 */
/*
 * @Repository public class HibernateTempleteClass implements Manager {
 *//** The session factory. */
/*
 * private HibernateTemplate hibernateTemplate;
 *//**
 * Gets the session factory.
 * 
 * @return the session factory
 */
/*

	*//**
 * Sets the session factory.
 * 
 * @param sessionFactory
 *            the new session factory
 */
/*
 * 
 * 
 * (non-Javadoc)
 * 
 * @see com.skbh.dao.Manager#getCountcircle()
 * 
 * @Override public int getCountcircle() { Session session =
 * getHibernateTemplate().getSessionFactory() .openSession(); Query query =
 * session.createQuery("select count(*) from Circle"); return ((Long)
 * query.uniqueResult()).intValue();
 * 
 * }
 * 
 * 
 * (non-Javadoc)
 * 
 * @see com.skbh.dao.Manager#getCountcircleByName(java.lang.String)
 * 
 * @Override public int getCountcircleByName(String name) { Session session =
 * getHibernateTemplate().getSessionFactory() .openSession(); Query query =
 * session .createQuery("select count(*) from Circle where name=?");
 * query.setString(0, name); return ((Long) query.uniqueResult()).intValue(); }
 * 
 * public HibernateTemplate getHibernateTemplate() { return hibernateTemplate; }
 * 
 * public void setHibernateTemplate(SessionFactory sessionFactory) {
 * this.hibernateTemplate = new HibernateTemplate(sessionFactory); }
 * 
 * }
 */
