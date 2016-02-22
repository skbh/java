package in.skbh.svn.webservice.manager.Impl;

import in.skbh.svn.webservice.manager.EbizUploadManager;
import in.skbh.svn.webservice.pojo.EBizRegistrationObjectsMapping;
import in.skbh.svn.webservice.pojo.EBizUploadedObjects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class EbizUploadManagerImpl implements EbizUploadManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer saveEBizUploadedObjectsInDataBase(
			EBizUploadedObjects eBizUploadedObjects) {
		Session session = null;
		Transaction transaction = null;
		Integer eBizRefrenceId=null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			eBizRefrenceId=(Integer) session.save(eBizUploadedObjects);
			transaction.commit();
			return eBizRefrenceId;
		} catch (HibernateException he) {
				he.printStackTrace();
				transaction.rollback();
				return null;	//failed to save objects into DB returning null
		} finally {//end catch
			try {
				if (session != null && session.isOpen()) {
					session.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}//end finally catch

		}// End finally
		
	}// End saveEBizUploadedObjectsInDataBase method

	@Override
	public Integer saveEBizUploadedObjectsInDataBase(
			EBizRegistrationObjectsMapping eBizRegistrationObjectsMapping) {
		Session session = null;
		Transaction transaction = null;
		Integer eBizRefrenceId=null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			eBizRefrenceId=(Integer) session.save(eBizRegistrationObjectsMapping);
			transaction.commit();
			return eBizRefrenceId;
		} catch (HibernateException he) {
				he.printStackTrace();
				transaction.rollback();
				return null;	//failed to save objects into DB returning null
		} finally {//end catch
			try {
				if (session != null && session.isOpen()) {
					session.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}//end finally catch

		}// End finally
	}

}
