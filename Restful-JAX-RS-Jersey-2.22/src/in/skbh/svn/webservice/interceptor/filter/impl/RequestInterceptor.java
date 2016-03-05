package in.skbh.svn.webservice.interceptor.filter.impl;

import in.skbh.svn.webservice.exception.AccessDeniedForbiddenException;
import in.skbh.svn.webservice.manager.WebServiceLogManager;
import in.skbh.svn.webservice.pojo.WebserviceAuthenticatedIPAddress;
import in.skbh.svn.webservice.pojo.WebserviceResourceAccessLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Provider
public class RequestInterceptor implements ContainerRequestFilter,ContainerResponseFilter{

	private static final Logger logger = Logger.getLogger(RequestInterceptor.class);
	@SuppressWarnings("unused")
	/*----------------------------------------------------------------------------------*/
	/**/private static final Map<String,String>  listOfAuthenticatedIPAddressesUnmodifiable;
	/**/static {
	/**/Map<String,String>  tempMap=new LinkedHashMap<String,String>();
	/**/tempMap.put("NIC_PUBLIC_IP", "164.100.8.3");tempMap.put("NIC_LOCAL_IP", "10.21.178.206");
	/**/listOfAuthenticatedIPAddressesUnmodifiable = Collections.unmodifiableMap(tempMap);
	/**/}
	/*----------------------------------------------------------------------------------*/	
	@Context
    private HttpServletRequest httpServletRequest;
	@Autowired
	private WebServiceLogManager webServiceLogManager;
	
	
	public WebServiceLogManager getWebServiceLogManager() {
		return webServiceLogManager;
	}

	public void setWebServiceLogManager(WebServiceLogManager webServiceLogManager) {
		this.webServiceLogManager = webServiceLogManager;
	}

	@Override
	public void filter(ContainerRequestContext crc) throws IOException, AccessDeniedForbiddenException {
		String url=crc.getUriInfo().getAbsolutePath().toString();
		String ipAddress=httpServletRequest.getRemoteAddr();
		String methodName=crc.getRequest().getMethod();
		boolean isSecure=crc.getSecurityContext().isSecure();
		boolean isAsyncStarted=httpServletRequest.isAsyncStarted();
		boolean isRequestedSessionIdValid=httpServletRequest.isRequestedSessionIdValid();
		Date resourceCreationTime=new Date(httpServletRequest.getSession().getCreationTime());
		Date resourceLastAccessedTime=new Date(httpServletRequest.getSession().getLastAccessedTime());
		String authenticatedIpAddress_NIC_PUBLIC_IP=null;
		String clientIP_Address = null;
		if(logger.isDebugEnabled()){
			logger.info("...................start Intercepting ReQuest.................................");
			logger.info("URI# " + url);
			logger.info("IP-address# " + ipAddress);
			logger.info("method name# " + methodName);
			logger.info("isSecure# " + isSecure);
			logger.info("Creation Time# " + resourceCreationTime);
			logger.info("Last Accessed Time# " + resourceLastAccessedTime);
			logger.info("isAsyncStarted# " + isAsyncStarted);
			logger.info("isRequestedSessionIdValid# " + isRequestedSessionIdValid);
			logger.info("...................END Intercepting ReQuest.................................");
		}
		
		String ipAddressLIKE=prepareIPAddress(ipAddress);
		WebserviceAuthenticatedIPAddress webserviceAuthenticatedIPAddress=webServiceLogManager.retrieveWebserviceAuthenticatedIPAddress(ipAddressLIKE);
		
		if(webserviceAuthenticatedIPAddress!=null){
			authenticatedIpAddress_NIC_PUBLIC_IP=extractIPAddress(webserviceAuthenticatedIPAddress.getIpAddress());
			clientIP_Address=extractIPAddress(ipAddress);
		}
		
		if(logger.isDebugEnabled()){
			logger.info("...................start next Intercepting ReQuest.................................");
			logger.info("clientIP_Address# " + clientIP_Address);
			logger.info("authenticatedIpAddress_NIC_PUBLIC_IP# " + authenticatedIpAddress_NIC_PUBLIC_IP);
			logger.info("...................END next Intercepting ReQuest.................................");
		}
		
		if(webserviceAuthenticatedIPAddress==null)
			throw new AccessDeniedForbiddenException("Access Denied!");	
		
		
	}

	@Override
	public void filter(ContainerRequestContext crc,	ContainerResponseContext response) throws IOException {
		String uri=crc.getUriInfo().getAbsolutePath().toString();
		String ipAddress=httpServletRequest.getRemoteAddr();
		String methodName=crc.getRequest().getMethod();
		boolean isSecure=crc.getSecurityContext().isSecure();
		boolean isAsyncStarted=httpServletRequest.isAsyncStarted();
		boolean isRequestedSessionIdValid=httpServletRequest.isRequestedSessionIdValid();
		Integer maxInactiveInterval=httpServletRequest.getSession().getMaxInactiveInterval();
		Date resourceCreationTime=new Date(httpServletRequest.getSession().getCreationTime());
		Date resourceLastAccessedTime=new Date(httpServletRequest.getSession().getLastAccessedTime());
		Integer reponseStatusCode=response.getStatus();
		String responseStatusInfo=response.getStatusInfo().getReasonPhrase();
		String responseClassName = null;
		if(response.getEntity()!=null && response.getEntity().getClass()!=null){
			if(response.getEntity().getClass()!=null){
				if(response.getEntity().getClass().getName()!=null){
					responseClassName=response.getEntity().getClass().getName().toString();
			}
		}
		}
			else
				responseClassName="Exception Occured!";
				
		WebserviceResourceAccessLog webserviceResourceAccessLog=new WebserviceResourceAccessLog();
		webserviceResourceAccessLog.setUri(uri);
		webserviceResourceAccessLog.setIpAddress(ipAddress);
		webserviceResourceAccessLog.setIsAsyncStarted(isAsyncStarted);
		webserviceResourceAccessLog.setIsRequestedSessionIdValid(isRequestedSessionIdValid);
		webserviceResourceAccessLog.setIsSecure(isSecure);
		webserviceResourceAccessLog.setMaxInactiveInterval(maxInactiveInterval);
		webserviceResourceAccessLog.setMethodName(methodName);
		webserviceResourceAccessLog.setResourceAccessTime(resourceCreationTime);;
		webserviceResourceAccessLog.setResourceLastAccessedTime(resourceLastAccessedTime);
		webserviceResourceAccessLog.setResponseClassName(responseClassName);
		webserviceResourceAccessLog.setResponseStatusCode(reponseStatusCode);
		webserviceResourceAccessLog.setResponseStatusInfo(responseStatusInfo);
				
		Boolean webServiceLogStatus=webServiceLogManager.saveWebserviceLog(webserviceResourceAccessLog);
		if(logger.isDebugEnabled()){
			logger.info("...................start Intercepting Response.................................");
			logger.info("URI# " + uri);
			logger.info("IP-address# " + ipAddress);
			logger.info("methodName# " + methodName);
			logger.info("reponse Status Code# " + reponseStatusCode);
			logger.info("response Status Info# " + responseStatusInfo);
			logger.info("response Class Name# " + responseClassName);
			logger.info("WebService Log Saving Status# " + webServiceLogStatus);
			logger.info("...................END Intercepting Response.................................");
		}
		
	}
	
	
	private String extractIPAddress(String ipAddress){
		List<String> SplitIPAddress=new ArrayList<String>();
		StringBuilder ipToBeValidated=new StringBuilder();
		
		for (String ip : ipAddress.split("\\.")) {
			SplitIPAddress.add(ip);
		}
		
		ipToBeValidated.append(SplitIPAddress.get(0));
		ipToBeValidated.append(SplitIPAddress.get(1));
		ipToBeValidated.append(SplitIPAddress.get(2));
		ipToBeValidated.append(SplitIPAddress.get(3));
		
		return ipToBeValidated.toString();
		
	}
	
	private String prepareIPAddress(String ipAddress){
		List<String> SplitIPAddress=new ArrayList<String>();
		StringBuilder ipToBePrepared=new StringBuilder();
		
		for (String ip : ipAddress.split("\\.")) {
			SplitIPAddress.add(ip);
		}
		
		ipToBePrepared.append(SplitIPAddress.get(0));
		ipToBePrepared.append(".");
		ipToBePrepared.append(SplitIPAddress.get(1));
		ipToBePrepared.append(".");
		ipToBePrepared.append(SplitIPAddress.get(2));
		ipToBePrepared.append(".");
		ipToBePrepared.append(SplitIPAddress.get(3));
		ipToBePrepared.append("%");
		
		return ipToBePrepared.toString();
		
	}

}
