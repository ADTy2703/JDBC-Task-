package com.tka;
// Count the number of posts by each author

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProblemStatement10 {

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
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT a.id ,a.first_name, a.last_name, count(p.id) as post_count  FROM authors a LEFT JOIN posts p ON a.id = p.id GROUP BY a.id,a.first_name,a.last_name ";

			PreparedStatement preparedStatement = con.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int count = rs.getInt(4);

				System.out.println(id + "    " + firstName + "    " + lastName + "    " + count);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
