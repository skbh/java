/*
 * @Software Engineer Sushil Kumar Bhaskar
 * @Author SKBH
 * @Version SSDSV2.0
 * @Since Aug 31, 2015
 * @FileName MyResource.java
 * @ProjectFullName Shram Suvidha Data Sharing System
 * @ProjectName SSDS
 * @LeagalInfo  Copyright 2015 Shram Suvidha - Unified Portal for Labour and Employment  All Rights Reserved.
 * @Redistribution Redistribution and use in source and binary forms, with or without modification, are NOT permitted.
 */
package in.skbh.svn.webservice;


import in.skbh.svn.webservice.pojo.model.ApplicationStatus;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class MyResource.
 */
@Path("serverstatus")
@net.bull.javamelody.MonitoredWithSpring
public class ServerStatus{

    /** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ServerStatus.class);
	
	/** The Constant applicationStatusSuccess. */
	private static final String applicationStatusSuccess="Running OK.200, Got it!"; 
    
    /**
     * Gets the  status of application.
     *
     * @return Application Status
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
    	ApplicationStatus applicationStatus=new ApplicationStatus();
    	String DatabaseRunningStatus;
    	String sslStatus;
    	String nonsslStatus;
    	//Boolean DBRunningStatus=CheckServerStatusService.isDatabaseOnline("10.21.178.2", 5432); //Development
    	Boolean DBRunningStatus=CheckServerStatusService.isDatabaseOnline("10.25.120.77", 5432); // testing
    	if(DBRunningStatus){
    		DatabaseRunningStatus="Running OK.200, Got it!";
    		if(logger.isDebugEnabled()){
    			logger.debug("Application Status : Running OK.200 , Got it! " + 
    					"Database Status : " + DatabaseRunningStatus);
    		}
    	}
    	else{
    		DatabaseRunningStatus="NOT RUNNING! Please check Database Server IP";
    		if(logger.isDebugEnabled()){
    			logger.debug("Application  Status : OK.200 , Got it! " + 
    					"Database   Running Status : " + DatabaseRunningStatus);
    		}
    	}
       	Boolean ssl=CheckServerStatusService.hostAvailabilityCheck("localhost", 8443);
    	if(ssl)	sslStatus="Running OK.200, Got it!";
    	else    sslStatus="OOPS.404 NOT RUNNING! Please check Server IP";
    	Boolean nonssl=CheckServerStatusService.hostAvailabilityCheck("localhost", 8080);
    	if(nonssl)	nonsslStatus="Running OK.200, Got it!";
       	else   		nonsslStatus="OOPS.404 NOT RUNNING! Please check Server IP";
    
    	String html="<html><HEAD><title>-:WebService Server Status:-</title></head>";
    	String font="<body bgcolor='#ECECEA'><font face='verdana' size='2' color='#657079'>";
    	String htmlclose="</font></body></html>";
    	Map<Long, String> jvmMemory=CheckServerStatusService.getJVMMemoryDetail();
    	List<Long> jvmMemoryList=CheckServerStatusService.getSimpleJVMMemoryDetail();
    	StringBuilder jvmMemoryMonitor=new StringBuilder();
    	for (Map.Entry<Long, String> entry : jvmMemory.entrySet())
    	{
    		jvmMemoryMonitor.append(entry.getValue() + "&nbsp;&nbsp;&nbsp;&nbsp; :"+entry.getKey() + " MEGABYTE" + "<br>");
    	}
            
    	applicationStatus.setApplicationStatus(applicationStatusSuccess);
    	applicationStatus.setDatabaseStatus(DatabaseRunningStatus);
    	applicationStatus.setSecureSocketLayerStatusPort8443(sslStatus);
    	applicationStatus.setNonSecureSocketLayerStatusPort8080(nonsslStatus);
    	applicationStatus.setUsedHeapSizeMemory(jvmMemoryList.get(0));
		applicationStatus.setFreeHeapSizeMemory(jvmMemoryList.get(1));
		applicationStatus.setTotalHeapHeapSizeMemory(jvmMemoryList.get(2));
		applicationStatus.setMaximumHeapHeapSizeMemory(jvmMemoryList.get(3));
    	applicationStatus.setHtmlContent(html + font + "Application Status : Running OK.200, Got it!  " + "<br>" +
    			"Database &nbsp; Status : " + DatabaseRunningStatus +"<br>"  +
    			"Secure Socket Layer Status port 8443: " + sslStatus +"<br>" + 
    			"Non Secure Socket Layer Status port 8080: " + nonsslStatus +"<br>"  + "<br>" +
    			jvmMemoryMonitor + htmlclose);
    	return Response.ok().entity(applicationStatus).build();
            
    }
     
}
