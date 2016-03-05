package in.skbh.svn.webservice.manager.Impl;

import in.skbh.svn.webservice.manager.WebServiceLogManager;
import in.skbh.svn.webservice.pojo.WebserviceAuthenticatedIPAddress;
import in.skbh.svn.webservice.pojo.WebserviceResourceAccessLog;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class WebServiceLogManagerImpl implements WebServiceLogManager{

	private static final Logger logger = Logger.getLogger(WebServiceLogManagerImpl.class);
	
	@Autowired
	private SessionFactory  sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveWebserviceLog(WebserviceResourceAccessLog webserviceResourceAccessLog) {
		Session session =sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(webserviceResourceAccessLog!=null){
		try {
			session.save(webserviceResourceAccessLog);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
				try
				{
					if(session!=null && session.isOpen()){
		    			session.close();
		    		}//end if
				} catch (Exception e) {
					e.printStackTrace();
				}//end catch

		}// end finally block
	
		}else //if(webserviceResourceAccessLog!=null)
		return false;
		
		return true;
	}

	@Override
	public WebserviceAuthenticatedIPAddress retrieveWebserviceAuthenticatedIPAddress(String ipAddress) {
		Session session = null;
		Transaction tx = null;
		Query query = null;
		WebserviceAuthenticatedIPAddress webserviceAuthenticatedIPAddress=null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			query = session.createQuery("from WebserviceAuthenticatedIPAddress where ipAddress like :ipAddress");
			query.setString("ipAddress", ipAddress);
			query.setCacheable(true);
			webserviceAuthenticatedIPAddress = (WebserviceAuthenticatedIPAddress) query.uniqueResult();
			tx.commit();
			}// end try block
		catch (HibernateException He)// end try and start catch
		{
			if (logger.isDebugEnabled()) {
				logger.debug("HibernateException : " + He);
			}
			return null;
			
		} finally {// end catch begin finally
			try {
				if (session != null)
					session.close();
			} catch (HibernateException he) {// end try and start catch
				if (logger.isDebugEnabled()) {
					logger.debug("HibernateException : session is closed # " + he);
				}

			}// end catch
		}// end finally
		
		if(webserviceAuthenticatedIPAddress!=null)
			return webserviceAuthenticatedIPAddress;
		
		return null;
	}

}
