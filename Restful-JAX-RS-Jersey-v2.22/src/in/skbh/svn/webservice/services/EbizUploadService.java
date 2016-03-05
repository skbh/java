package in.skbh.svn.webservice.services;

import in.skbh.svn.webservice.pojo.EBizRegistrationObjectsMapping;
import in.skbh.svn.webservice.pojo.EBizUploadedObjects;


public interface EbizUploadService {
	
	public Integer saveEBizUploadedObjects(EBizUploadedObjects eBizUploadedObjects);
	public Integer saveEBizUploadedObjects(EBizRegistrationObjectsMapping eBizRegistrationObjectsMapping);

}
