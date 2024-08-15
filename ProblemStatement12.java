package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// List all authors in alphabetical order by last name

public class ProblemStatement12 {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_task";
	private static final String USERNAME = "root";
	private static final String PASSWORD ="Aditya@123";
	
	public static void main(String[] args) {
   
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			String query = "SELECT * FROM authors ORDER BY last_name";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				System.out.println(id+" "+firstName+" "+lastName+" "+email);
			}
		}
		catch(SQLException e) {
		    e.printStackTrace();	
		}
	}
}
