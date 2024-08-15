package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.PreparedQuery;
// Update an authors email

public class ProblemStatement3 {
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
			String query = "Update authors SET email = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "john.doe@gmail.com");
			preparedStatement.setInt(2, 5);

			int affected = preparedStatement.executeUpdate();

			if (affected > 0) {
				System.out.println("Data Updated Successfully");
			} else {
				System.out.println("Data Not Updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
