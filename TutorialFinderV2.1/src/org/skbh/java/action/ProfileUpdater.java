package org.skbh.java.action;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.skbh.java.model.UserRegisterData;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProfileUpdater  extends ActionSupport implements ModelDriven<UserRegisterData>, SessionAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String,Object> sessionMap;
	private UserRegisterData urd = new UserRegisterData();
	HttpSession session=ServletActionContext.getRequest().getSession(false);
	String userid=(String) session.getAttribute("userid");

	
	public String execute(){
		if(profileUpdater()==true && session.getAttribute("LOGIN_OK")=="true")
		{
			if(UpdateIntoDataBase())
			 return SUCCESS;
			 else
			 return ERROR;
		}
		else
		{
		return LOGIN;
		}
		
		
	}
	
	
	
public boolean profileUpdater() {
		
		boolean ret=false;
		  Connection connection=null;
		   
		  try{
			     Class.forName("com.mysql.jdbc.Driver");
			     connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");
			      
			     
			     System.out.print("User Id : "  + userid);
			     System.out.print("LOGIN_OK : " + session.getAttribute("LOGIN_OK"));
			     urd.setUsername(userid);
			     String sql = "SELECT * FROM form WHERE field3 = ?";
			     PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			     ps.setString(1, userid);
		         ResultSet rs = ps.executeQuery();
		         
		         while (rs.next()) {
		                   	 
		        	/* urd.setFirstname(rs.getString("field1"));
		        	 urd.setLastname(rs.getString("field2"));
		        	 urd.setUsername(rs.getString("field3"));
		        	 urd.setContact(rs.getString("field5"));
		        	 urd.setAddress(rs.getString("field8"));
		        	 urd.setCountry(rs.getString("field7"));
		        	 urd.setEmail(rs.getString("field6"));
		        	 */
		        	 	        	 
		        	 
		        	 System.out.print(urd.getFirstname());
		        	 System.out.print(urd.getAddress());
		        	 System.out.print("user NMame :" + urd.getUsername());
		        	 
		        	 
		        	 
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
	

public boolean UpdateIntoDataBase()
{
	
	Connection connection = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		/*String sql = "update form set('" + urd.getFirstname()
				+ "','" + urd.getLastname() + "','" + urd.getUsername()
				+ "','" + urd.getContact()	+ "','" + urd.getEmail() + "','" + urd.getCountry() + "','"
				+ urd.getAddress() + "') where field3='"+ urd.getUsername() + "'"; */ 
		
		String sql = "update form set field1='"+urd.getFirstname()+"' ,field2='" +urd.getLastname()+ "',field5='" + urd.getContact()+ "',field6='" + urd.getEmail() + "',field7='" + urd.getCountry() + "',field8='"+ urd.getAddress() + "' where field3='"+ urd.getUsername() + "' ";
		//String sql = "update form set field1='"+urd.getFirstname()+"' ,field2='" +urd.getLastname()+ "' where field3='"+ urd.getUsername() + "' ";
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");

		Statement st = (Statement) connection.createStatement();
		int status = st.executeUpdate(sql);
      		if (status > 0)
			System.out.print("........................profile updated......................");
		else
			System.out.print("failure");

		return true;

	}
	
	catch (ClassNotFoundException e) {

		e.printStackTrace();
	}

	catch (SQLException e) {

		e.printStackTrace();
	}

	catch (Exception e) {

		e.printStackTrace();
	}

	finally {

		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	return false;
	
	
}


	

	@Override
		public void setSession(Map<String, Object>map) {
		setSessionMap((SessionMap<String, Object>) map);
		
	}
	public SessionMap<String,Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(SessionMap<String,Object> sessionMap) {
		this.sessionMap = sessionMap;
	}



	@Override
	public UserRegisterData getModel() {
		// TODO Auto-generated method stub
		return urd;
	}

}
