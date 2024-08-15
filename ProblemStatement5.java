package com.tka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// Insert a new post into the posts table

public class ProblemStatement5 {
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

			String query = "INSERT INTO posts (author_id,title,description,content,date) Values(?,?,?,?,?) ";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "My First Post");
			preparedStatement.setString(3, "This is the description of my first post");
			preparedStatement.setString(4, "This is the content of my first post");
			preparedStatement.setDate(5, Date.valueOf("2024-06-11"));

			int rowAffected = preparedStatement.executeUpdate();

			if (rowAffected > 0) {
				System.out.println("Data Inserted Successfully");
			} else {
				System.out.println("Data Not Inserted Successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
