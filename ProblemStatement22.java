package com.tka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Retrieve a limited number of recent posts

public class ProblemStatement22 {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc_task";
	private static final String USERNAME ="root";
	private static final String PASSWORD ="Aditya@123";
	
	public static void main(String[] args) {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
        	e.printStackTrace();
        }
        
        try {
        	Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        	
        	String query = "SELECT * FROM posts ORDER BY date DESC LIMIT 3";
        	
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
        	
        	ResultSet rs = preparedStatement.executeQuery();
        	
        	while(rs.next()) {
        		int id = rs.getInt(1);
				int auth_id = rs.getInt(2);
				String title = rs.getString(3);
				String desc = rs.getString(4);
				String content = rs.getString(5);
				Date date = rs.getDate(6);

				System.out.println(id + " - " + auth_id + " - " + title + " - " + desc + " - " + content + " - " + date);
        	}
        }catch(SQLException e) {
        	e.printStackTrace();
        }
	}
}
