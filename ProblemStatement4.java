package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// Delete an author by ID
public class ProblemStatement4 {
	
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
			Connection  connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			String query = "DELETE FROM authors where id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 6);
			
			int rowAffected = preparedStatement.executeUpdate();
			
			if(rowAffected>0) {
				System.out.println("Deleted Successfully");
			}else {
				System.out.println("Not Deleted");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
