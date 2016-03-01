package in.skbh.svn.webservice.manager;

import in.skbh.svn.webservice.pojo.EBizRegistrationObjectsMapping;
import in.skbh.svn.webservice.pojo.EBizUploadedObjects;


public interface EbizUploadManager {
	
	public Integer saveEBizUploadedObjectsInDataBase(EBizUploadedObjects eBizUploadedObjects);
	public Integer saveEBizUploadedObjectsInDataBase(EBizRegistrationObjectsMapping eBizRegistrationObjectsMapping);
}
