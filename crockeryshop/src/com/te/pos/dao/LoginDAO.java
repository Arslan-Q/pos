package com.te.pos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.te.pos.db.DBConnect;

public class LoginDAO {

	public Boolean loginToSystem(String username,String password) throws Exception{
		Boolean allowUserToLogin=false;
		Connection connection=DBConnect.connectDatabase();
		System.out.println("connection established for login to the system...");
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from user_details where username='"+username+"' and password='"+password+"'");
		if(resultSet.next()){
			allowUserToLogin=true;
		}
		
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return allowUserToLogin;
	}
}
