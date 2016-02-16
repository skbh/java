package org.skbh.java.action;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.skbh.java.model.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> ,SessionAware   {
	
	private static final long serialVersionUID = 1L;
	private User user=new User();
	private SessionMap<String,Object> sessionMap;
	
	public boolean check() {
		
		boolean ret=false;
		  Connection connection=null;
		   
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");
			  String sql = "SELECT field1 FROM form WHERE field3 = ? AND field4 = ?";
			     PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			     ps.setString(1, user.getUserid());
		         ps.setString(2, user.getPassword());
		         ResultSet rs = ps.executeQuery();

		         while (rs.next()) {
		        	  user.setName(rs.getString(1));
		        	  ret = true;
		         }
			  
		     }
		   catch (Exception e) {
		      ret = false;
		   } 
		  
	  finally {
	      if (connection != null) {
	         try {
	        	 connection.close();
	         } catch (Exception e) {
	         }
	      }
	   }
		return ret;
		
	}
	
	public void validate() {
		
			if(StringUtils.isEmpty(user.getUserid())){
			addFieldError("userid", "User Id cannot be blank");
		}
					
	    if(StringUtils.isEmpty(user.getPassword()))
	    	addFieldError("password", "Password cannot be blank");
    
			
    }
	
	
  public String execute(){
	 clearFieldErrors();
	  boolean result=check();
	  if(result==true){
		  sessionMap.clear();	
		  sessionMap.put("userid",user.getUserid());
		  sessionMap.put("LOGIN_OK", "true");
		  		  
		  return SUCCESS;  
	  }
	  else{ 
		 addFieldError("invalid","Invalid User Name & Password");
		 return INPUT;
	  }
	  	   
 }

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public User getModel() {
	
	return user;
}


@Override
public void setSession(Map<String, Object> map) {
	sessionMap=(SessionMap<String, Object>) map;
	
}

public SessionMap<String,Object> getSessionMap() {
	return sessionMap;
}

public void setSessionMap(SessionMap<String,Object> sessionMap) {
	this.sessionMap = sessionMap;
}


  
}













/*package org.skbh.java.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action   {
	
	private String userid;
	private String password;
	
  public String execute(){
	  if(getUserid().equals("userid") && getPassword().equals("password")){
		  return SUCCESS;
	  }
	  
		  return LOGIN;
	  
	  }

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}
  
}
*/