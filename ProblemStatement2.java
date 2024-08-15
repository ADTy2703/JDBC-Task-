package com.tka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Retrieve an author by email

public class ProblemStatement2 {
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
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "SELECT * FROM authors where email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "aawankhade123@gmail.com");
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
			int	id = rs.getInt(1);
			String firstName=	rs.getString(2);
			String lastName =	rs.getString(3);
			String email = 	rs.getString(4);
			Date date =	rs.getDate(5);
				
			System.out.println(id +" | "+firstName+" | "+lastName+" | "+email+" | "+date);

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
