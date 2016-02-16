package org.skbh.java.action;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.skbh.java.model.UserRegisterData;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUserProfile extends ActionSupport implements SessionAware {
	private SessionMap<String,Object> sessionMap;
	
	private static final long serialVersionUID = 1L;
	private UserRegisterData urd = new UserRegisterData();
	HttpSession session=ServletActionContext.getRequest().getSession(false);
	
	public String execute(){
		if(profileGetter()==true && session.getAttribute("LOGIN_OK")=="true")
			return SUCCESS;
		return LOGIN;
		
		
	}
	
	
	
	public boolean profileGetter() {
		
		boolean ret=false;
		  Connection connection=null;
		   
		  try{
			     Class.forName("com.mysql.jdbc.Driver");
			     connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");
			       
			     
			     String userid=(String) session.getAttribute("userid");
			     System.out.print("User Id : "  + userid);
			     System.out.print("LOGIN_OK : " + session.getAttribute("LOGIN_OK"));
			     String sql = "SELECT * FROM form WHERE field3 = ?";
			     PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			     ps.setString(1, userid);
		         ResultSet rs = ps.executeQuery();
		         
		         while (rs.next()) {
		          	 sessionMap.put("firstName",rs.getString("field1"));
		        	 sessionMap.put("lastName",rs.getString("field2"));
		        	 sessionMap.put("userId",rs.getString("field3"));
		        	 sessionMap.put("contactNumber",rs.getString("field5"));
		        	 sessionMap.put("emailId",rs.getString("field6"));
		        	 sessionMap.put("countryName",rs.getString("field7"));
		        	 sessionMap.put("address",rs.getString("field8"));
		        	 
		        	 urd.setFirstname(rs.getString("field1"));
		        	 urd.setLastname(rs.getString("field2"));
		        	 urd.setUsername(rs.getString("field3"));
		        	 urd.setContact(rs.getString("field5"));
		        	 urd.setAddress(rs.getString("field8"));
		        	 urd.setCountry(rs.getString("field7"));
		        	 urd.setEmail(rs.getString("field6"));
		        	 
		        	 	        	 
		        	 
		        	 System.out.print(urd.getFirstname());
		        	 System.out.print(urd.getAddress());
		        	 
		        	 
		        	 
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