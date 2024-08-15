package com.tka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// Insert n new author into the authors table

public class ProblemStatement1 {

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
			
			String query = "INSERT INTO authors(first_name,last_name,email,birthdate) VALUES (?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,"Aditya");
			preparedStatement.setString(2, "Wankhade");
			preparedStatement.setString(3, "aawankhade123@gmail.com");
			preparedStatement.setDate(4,new Date(2002-03-27));
			
			int rowAffected = preparedStatement.executeUpdate();
			
			if(rowAffected>0) {
				System.out.println("Data Inserted Successfully");
			}else {
				System.out.println("Data Not Inserted ");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
