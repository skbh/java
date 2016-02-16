package com.skbh.action;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.skbh.dao.EmpDao;
import com.skbh.model.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>,Preparable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String message;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void prepare() throws Exception {
		user=new User();
		message="";
	}

	@Override
	public User getModel() {
		return user;
	}

	public String create(){
		System.out.println("excute method ran");
		message=new EmpDao().createUser(user);
		System.out.println(message);
		if(message.equals("User Created")){
			System.out.println("User Created");
			return SUCCESS;
		}
		else
			return ERROR;
	
	}
	public String sign(){
		
		User userDB=new EmpDao().signUser(user.getUsername(),user.getPassword());
		if(userDB == null) return ERROR;
		else
		{	
		message="User Found, Successfull login";
		user.setUsername(userDB.getUsername());
		user.setPassword(userDB.getPassword());
			return SUCCESS;
		}
					
	}

	@Override
	public void validate() {
		if(StringUtils.isEmpty(user.getUsername())){
			addFieldError("username","Username can't blank");
		}
		if(StringUtils.isEmpty(user.getPassword())){
			addFieldError("password","Password can't blank");
		}
			
	}
}
