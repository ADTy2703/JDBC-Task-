package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Group posts by author and count the number of posts for each author

public class ProblemStatement19 {

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

			String query = "SELECT a.first_name, a.last_name, COUNT(p.id) AS post_count FROM authors a LEFT JOIN posts p ON a.id=p.author_id GROUP BY a.id,a.first_name,a.last_name";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String first = rs.getString(1);
				String last = rs.getString(2);
				int pid = rs.getInt(3);

				System.out.println(first + " --- " + last + " --- " + pid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
