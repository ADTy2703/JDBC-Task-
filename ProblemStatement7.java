package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.PreparedQuery;

// Update a posts title and description

public class ProblemStatement7 {
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
			
			String query = "UPDATE posts SET title = ? ,description = ? WHERE id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,"Updated Title");
			preparedStatement.setString(2, "Updated Description");
			preparedStatement.setInt(3, 1);
			
			int rowAffected = preparedStatement.executeUpdate();
			
			if(rowAffected>0) {
				System.out.println("Data Updated Successfully");
			}else {
				System.out.println("Data not Updated");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
