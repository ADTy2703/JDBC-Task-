package com.tka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Retrieve the oldest author
public class ProblemStatement21 {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_task";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aditya@123";

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
	        String query = "SELECT * FROM authors ORDER BY birthdate ASC LIMIT 1";
	        
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        
	        ResultSet rs = preparedStatement.executeQuery();
	        
	        while(rs.next()) {
	        	int id = rs.getInt(1);
	        	String fname= rs.getString(2);
	        	String lname = rs.getString(3);
	        	String email = rs.getString(4);
	        	Date date = rs.getDate(5);
	        	
	           System.out.println(id +" --- "+fname+" --- "+lname+" --- "+email+" --- "+date+"\n");
	           
	        }
	        
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
