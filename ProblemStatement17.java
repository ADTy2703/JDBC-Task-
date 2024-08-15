package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Retrieve post title and author names together

public class ProblemStatement17 {

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
			
			String query = "SELECT p.title, a.first_name,a.last_name FROM posts p INNER JOIN authors a ON p.author_id = a.id";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				
				System.out.println(title+" --- "+firstName+" --- "+lastName);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
