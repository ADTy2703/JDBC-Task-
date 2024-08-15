package com.tka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Insert multiple authors

public class ProblemStatement18{
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_task";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aditya@123";

	public static void main(String[] args) {

		List<AuthorsData> authorslist = new ArrayList<>();
		authorslist.add(new AuthorsData("Salman","Khan", "salman@gmail.com",Date.valueOf("1998-07-09")));
		authorslist.add(new AuthorsData("Rashmika","Mandhana","rashmika@gmail.com",Date.valueOf("1989-04-06")));
		authorslist.add(new AuthorsData("Shahrukh","Khan","shahrukh@gmail.com",Date.valueOf("1978-06-03")));
		authorslist.add(new AuthorsData("Akshay","Kumar","akshay@gmail.com",Date.valueOf("1975-06-23")));
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			String query = "INSERT INTO authors (first_name, last_name, email,birthdate) VALUES (?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			for(AuthorsData auth : authorslist) {
				preparedStatement.setString(1,auth.getFirstName());
				preparedStatement.setString(2,auth.getLastName());
				preparedStatement.setString(3,auth.getEmail());
				preparedStatement.setDate(4, auth.getDate());
				preparedStatement.addBatch();
			}
			
			int [] rowsInserted = preparedStatement.executeBatch();
			
			if(rowsInserted.length>0) {
				System.out.println("Multiple authors inserted successfully");
			}else {
				System.out.println("Oops !! Data Not inserted");
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
