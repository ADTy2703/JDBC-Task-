package com.tka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Retrieve authors who have posted on a specific date

public class ProblemStatement9 {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_task";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aditya@123";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			String query = "SELECT * FROM authors INNER JOIN posts ON authors.id = posts.author_id WHERE posts.date = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, Date.valueOf("2024-06-11"));
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				String email = rs.getString(4);
				Date date = rs.getDate(5);
				
				System.out.println(id);
				System.out.println(first_name);
				System.out.println(last_name);
				System.out.println(email);
				System.out.println(date);
				
			}
			
			
			
		//	preparedStatement.
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
