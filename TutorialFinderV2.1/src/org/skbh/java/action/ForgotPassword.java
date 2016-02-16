package org.skbh.java.action;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.skbh.java.action.emailCode.SendMail;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPassword extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String Email;
	private String password;
	private String Name;

	public boolean findEmail() {

		boolean ret = false;
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");
			String sql = "SELECT field4 ,field1 FROM form WHERE field6 = ?";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, getEmail());
			ResultSet rs = ps.executeQuery();
			System.out.println(getEmail());
			System.out.println(getPassword());
			while (rs.next()) {
				System.out.println(rs.getString(1));
				setPassword(rs.getString(1));
				
				setName(rs.getString(2));
				
				ret = true;
			}

		} catch (Exception e) {
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

	
	public String execute() {
		clearFieldErrors();
		boolean result = findEmail();
		if (result == true) {
			SendMail sendemail = new SendMail();
			sendemail.emailPassword(getPassword(),getName(),getEmail());
			addActionMessage("Email Has Sent to :" + getEmail());
			return SUCCESS;
		} else {
			addFieldError("Email", "User & Email ID Not Found");
			return INPUT;
		}

	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}

}
