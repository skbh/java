package com.database.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataBase {

	public static void main(String[] args) {
		String delete = "delete from emp where empId > ?";
		String sql = "insert into emp (empId, name) values (?,?)";
		// Batch processing String sql="insert into emp values (?,?)";
		// Batch processing optional to provide(empId, name)

		Connection connection = null;
		PreparedStatement psstatement = null;
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
					"postgres", "postgres");
			psstatement = (PreparedStatement) connection.prepareStatement(sql);

			long start = System.currentTimeMillis();
			for (i = 200; i <= 250; i++) {
				int j = 1;
				psstatement.setInt(1, i);
				psstatement.setString(2, "name" + j);
				psstatement.addBatch();
			}
			psstatement.executeBatch();

			// String inject = "10 or 1=1"; // sql injection
			String inject = "10";
			int data = 0;
			long end = System.currentTimeMillis();
			System.out.println("batch process time :" + (end - start) / 1000 + " Seconds");
			// ResultSet resultset = psstatement.executeQuery("select * from emp
			// where empid >" + inject);// sql injection
			ResultSet resultset = psstatement.executeQuery("select * from emp where empid >" + inject);
			psstatement.setString(1, inject);
			while (resultset.next()) {
				System.out.print("EmpId :" + resultset.getInt("empId") + " ");
				System.out.print("EmpName :" + resultset.getString("name"));
				System.out.println();

			}

			try {
				System.out.println("Waiting... for 10 sec then data will be deleted");
				Thread.sleep(10000);
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(delete);
				preparedStatement.setInt(1, data);
				// preparedStatement.executeUpdate();
				System.out.println("Deleted all " + --i + " Records");
			} catch (SQLException SQLEx) {
				SQLEx.printStackTrace();
			} catch (InterruptedException IE) {
				IE.printStackTrace();
			}
		} catch (ClassNotFoundException ClassNotFound) {
			ClassNotFound.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psstatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}

/*
 * public class DataBase {
 * 
 * public static void main(String[] args) throws SQLException { String sql=
 * "insert into emp (empId, name) values (?,?)";//Batch processing
 * 
 * Connection connection; PreparedStatement psstatement; try {
 * Class.forName("com.mysql.jdbc.Driver"); connection=(Connection)
 * DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");
 * psstatement=(PreparedStatement) connection.prepareStatement(sql); long
 * start=System.currentTimeMillis(); for(int i=1;i<=10;i++){
 * psstatement.setInt(1, i); psstatement.setString(2, "name"+ i);
 * psstatement.executeUpdate(); }
 * 
 * long end=System.currentTimeMillis(); System.out.println(
 * "batch process time :" + (end-start));
 * 
 * 
 * } catch (ClassNotFoundException e) { e.printStackTrace(); }
 * 
 * 
 * }
 * 
 * }
 * 
 */

/*
 * public class DataBase {
 * 
 * public static void main(String[] args) throws SQLException { // String sql=
 * "insert into emp (empId, name) values (?,?)"; String sql="select * from emp";
 * Connection connection; Statement statement; try {
 * Class.forName("com.mysql.jdbc.Driver"); connection=(Connection)
 * DriverManager.getConnection("jdbc:mysql://localhost/skbh", "root", "admin");
 * statement=(Statement) connection.createStatement(); ResultSet
 * resultset=statement.executeQuery(sql); while(resultset.next()) {
 * System.out.println(resultset.getInt("empId"));
 * System.out.println(resultset.getString("name"));
 * 
 * } } catch (ClassNotFoundException e) { e.printStackTrace(); }
 * 
 * 
 * }
 * 
 * }
 */