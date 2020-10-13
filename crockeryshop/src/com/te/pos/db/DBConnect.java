package com.te.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	
	public static Connection connectDatabase() {
		Connection connection = null;
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String dbURL="jdbc:mysql://localhost:3307/pos";
	            String userName="root";
	            String password="admin";
	            connection = DriverManager.getConnection(dbURL, userName, password);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return connection;
	}
	
	
}
