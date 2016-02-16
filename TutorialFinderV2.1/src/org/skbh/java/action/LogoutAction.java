package org.skbh.java.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SessionMap<String,Object> sessionMap=(SessionMap<String, Object>) ActionContext.getContext().getSession();
	
	public String execute() {
		
		System.out.print("logout value : " + sessionMap.get("LOGIN_OK"));
		// sessionMap.get("LOGIN_OK");
		if (sessionMap.get("LOGIN_OK") == "true") {
			sessionMap.clear();
			sessionMap.invalidate();
			
			sessionMap = new SessionMap<String, Object>(ServletActionContext.getRequest());				
			return SUCCESS;
		}
		return INPUT;

	}

	
		
	
}
