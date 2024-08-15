package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Calculate the count of posts by each author

public class ProblemStatement20 {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_task";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aditya@123";
	
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			String query = "SELECT author_id, COUNT(id) AS post_count FROM posts GROUP BY author_id";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int aid = rs.getInt(1);
				int id = rs.getInt(2);
				
				System.out.println(aid+"   "+id);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
