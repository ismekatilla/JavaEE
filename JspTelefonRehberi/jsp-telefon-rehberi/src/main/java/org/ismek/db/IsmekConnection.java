package org.ismek.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class IsmekConnection {

	private final static String url = "jdbc:mysql://localhost:3306/ismek?useTimezone=true&serverTimezone=Turkey";
	private final static String username = "root";
	private final static String password = "1234";
	
	public static Connection getConnetion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  
		return null;
	}
}