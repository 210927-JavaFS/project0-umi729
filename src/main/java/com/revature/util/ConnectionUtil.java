package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		
	
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// jdbc:postgresql: url to server (localhost) : port/ database
		String url = "jdbc:postgresql://javafx-210827.c6khjwo6tij9.us-east-2.rds.amazonaws.com:5432/javafs210927";
		String username = "postgres";
		String password = "password";
		
		// creating connection now
		return DriverManager.getConnection(url, username,password);
	}
}
