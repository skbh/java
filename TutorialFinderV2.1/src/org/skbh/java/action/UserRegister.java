package org.skbh.java.action;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.skbh.java.model.UserRegisterData;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserRegister extends ActionSupport implements ModelDriven<UserRegisterData> {

	private static final long serialVersionUID = 1L;
	private UserRegisterData urd = new UserRegisterData();
	
	public String execute() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String sql = "insert into form values('" + urd.getFirstname()
					+ "','" + urd.getLastname() + "','" + urd.getUsername()
					+ "','" + urd.getPassword() + "','" + urd.getContact()
					+ "','" + urd.getEmail() + "','" + urd.getCountry() + "','"
					+ urd.getAddress() + "')";
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");

			Statement st = (Statement) connection.createStatement();
			
			int status = st.executeUpdate(sql);

			if (status > 0)
				System.out.print("........................New User Created......................");
			else
				System.out.print("failure");

			return SUCCESS;

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
		return LOGIN;

	}

	@Override
	public UserRegisterData getModel() {

		return urd;
	}

	public UserRegisterData getUrd() {
		return urd;
	}

	public void setUrd(UserRegisterData urd) {
		this.urd = urd;
	}
}
