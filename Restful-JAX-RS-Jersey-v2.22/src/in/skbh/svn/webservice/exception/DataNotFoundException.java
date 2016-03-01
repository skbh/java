/*
 * @Software Engineer Sushil Kumar Bhaskar
 * @Author SKBH
 * @Version SSDSV2.0
 * @Since Aug 6, 2015
 * @FileName DataNotFoundException.java
 * @ProjectFullName Shram Suvidha Data Sharing System
 * @ProjectName SSDS
 * @LeagalInfo  Copyright 2015 Shram Suvidha - Unified Portal for Labour and Employment  All Rights Reserved.
 * @Redistribution Redistribution and use in source and binary forms, with or without modification, are NOT permitted.
 */
package in.skbh.svn.webservice.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class DataNotFoundException.
 */
@net.bull.javamelody.MonitoredWithSpring
public class DataNotFoundException extends RuntimeException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
		
	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param message the message
	 */
	public DataNotFoundException(String message) {
		super(message);
		}

	    
    
}
