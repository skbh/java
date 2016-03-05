package in.skbh.svn.webservice.manager;

import in.skbh.svn.webservice.pojo.WebserviceAuthenticatedIPAddress;
import in.skbh.svn.webservice.pojo.WebserviceResourceAccessLog;





public interface WebServiceLogManager {
	
	public boolean saveWebserviceLog(WebserviceResourceAccessLog webserviceResourceAccessLog);
	public WebserviceAuthenticatedIPAddress retrieveWebserviceAuthenticatedIPAddress(String ipAddress);

}
