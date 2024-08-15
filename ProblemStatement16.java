package com.tka;
// Archieve old posts

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProblemStatement16 {

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
			
			String queryMove = "INSERT INTO archived_posts SELECT * FROM posts WHERE date < ?";
			String queryDelete = "DELETE FROM posts WHERE date <?";
			
			PreparedStatement preparedMove = connection.prepareStatement(queryMove);
			preparedMove.setDate(1, Date.valueOf("2024-01-01"));
			
			PreparedStatement preparedDelete = connection.prepareStatement(queryDelete);
			preparedDelete.setDate(1,Date.valueOf("2024-01-01"));
			
			int countMove = preparedMove.executeUpdate();
			int countDelete = preparedDelete.executeUpdate();
			
			if(countMove >0 && countDelete >0) {
				System.out.println("Successfully Inserted and Deleted");
			}
			else {
				System.out.println("Oops !! Something went wrong !!");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
