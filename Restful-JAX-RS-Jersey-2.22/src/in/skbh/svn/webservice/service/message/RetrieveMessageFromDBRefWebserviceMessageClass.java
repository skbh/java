
package in.skbh.svn.webservice.service.message;

import in.skbh.svn.webservice.exception.DataNotFoundException;
import in.skbh.svn.webservice.pojo.RefWebserviceMessage;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * The Class RetrieveMessageFromDBRefWebserviceMessageClass.
 */
@net.bull.javamelody.MonitoredWithSpring
public class RetrieveMessageFromDBRefWebserviceMessageClass {
	
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
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Retrieve message from ref webservice message.
	 *
	 * @param code the code
	 * @return the string
	 */
	public String retrieveMessageFromRefWebserviceMessage(int code) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query = session
				.createQuery("from RefWebserviceMessage where id=:code");
		query.setCacheable(true);
		query.setInteger("code", code);
		RefWebserviceMessage message = (RefWebserviceMessage) query
				.uniqueResult();
		tx.commit();
		session.close();
		if(message==null){
			throw new DataNotFoundException("Message not found" + code);
		}
		
		return message.getMessages();

	}//getMessageFromRefWebserviceMessage

}
