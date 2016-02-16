package com.skbh.spring;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3159994444988482935L;

	public DrawEvent(Object source) {
		super(source);
		
	}

	@Override
	public String toString() {
		return "Event has been drawing...";
	}
	
	

}
