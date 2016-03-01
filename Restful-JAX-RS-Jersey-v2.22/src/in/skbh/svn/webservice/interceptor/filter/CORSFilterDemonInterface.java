/*
 * @Software Engineer Sushil Kumar Bhaskar
 * @Author SKBH
 * @Version SSDSV2.0
 * @Since Aug 13, 2015
 * @FileName CORSFilterDemonInterface.java
 * @ProjectFullName Shram Suvidha Data Sharing System
 * @ProjectName SSDS
 * @LeagalInfo  Copyright 2015 Shram Suvidha - Unified Portal for Labour and Employment  All Rights Reserved.
 * @Redistribution Redistribution and use in source and binary forms, with or without modification, are NOT permitted.
 */
package in.skbh.svn.webservice.interceptor.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

// TODO: Auto-generated Javadoc
/**
 * The Interface CORSFilterDemonInterface.
 */
public interface CORSFilterDemonInterface extends ContainerResponseFilter {
	
	/**
	 * CORS filter init.
	 *
	 * @param requestContext the request context
	 * @param responseContext the response context
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void CORSFilterInit(ContainerRequestContext requestContext, ContainerResponseContext responseContext)throws IOException;
	
}
