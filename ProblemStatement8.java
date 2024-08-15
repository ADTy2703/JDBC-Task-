package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Delete a post by ID
public class ProblemStatement8 {

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

			String query = "DELETE FROM posts WHERE id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 5);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Data DELETED Successfully");
			} else {
				System.out.println("Oops !! Data Not Deleted , Something went wrong !! ");
			}

		} catch (SQLException e) {

		}
	}
}
