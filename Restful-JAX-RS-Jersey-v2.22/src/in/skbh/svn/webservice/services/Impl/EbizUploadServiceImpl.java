package in.skbh.svn.webservice.services.Impl;

import in.skbh.svn.webservice.manager.Impl.EbizUploadManagerImpl;
import in.skbh.svn.webservice.pojo.EBizRegistrationObjectsMapping;
import in.skbh.svn.webservice.pojo.EBizUploadedObjects;
import in.skbh.svn.webservice.services.EbizUploadService;

import org.springframework.beans.factory.annotation.Autowired;

public class EbizUploadServiceImpl implements EbizUploadService{
	
	@Autowired
	private EbizUploadManagerImpl ebizUploadManager;
	
	
	
	public EbizUploadManagerImpl getEbizUploadManager() {
		return ebizUploadManager;
	}



	public void setEbizUploadManager(EbizUploadManagerImpl ebizUploadManager) {
		this.ebizUploadManager = ebizUploadManager;
	}



	@Override
	public Integer saveEBizUploadedObjects(EBizUploadedObjects eBizUploadedObjects) {
		return ebizUploadManager.saveEBizUploadedObjectsInDataBase(eBizUploadedObjects);
	}



	@Override
	public Integer saveEBizUploadedObjects(EBizRegistrationObjectsMapping eBizRegistrationObjectsMapping) {
		return ebizUploadManager.saveEBizUploadedObjectsInDataBase(eBizRegistrationObjectsMapping);
	}



}
