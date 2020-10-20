package com.te.pos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.te.pos.db.DBConnect;
import com.te.pos.model.*;
public class EmployeeDAO {
	
	public List<Employee> getAllEmployee() throws SQLException{
		List<Employee> employeeList=new ArrayList<Employee>();
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="select * from employee";
		ResultSet resultSet=statement.executeQuery(query);
		while (resultSet.next()) {
			
			try {
				employeeList.add(new Employee(resultSet.getLong("employeeId"),resultSet.getString("employeeName"),resultSet.getString("employeePhoneNo"), resultSet.getString("employeeCNIC"), resultSet.getString("employeeAddress"),resultSet.getString("employeeActiveYN"),resultSet.getString("employeeSalary")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null && !statement.isClosed()) {
			statement.close();
		}
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
		return employeeList;

	}
	
	public void insertEmployee(Employee employee) throws SQLException {
		Connection connection=DBConnect.connectDatabase();
		Statement statement=connection.createStatement();
		String query="INSERT INTO `employee` (`employeeId`, `employeeName`, `employeePhoneNo`, `employeeCNIC`, `employeeAddress`, `employeeActiveYN`, `employeeSalary`) VALUES (NULL, '"+employee.getEmployeeName()+"', '"+employee.getEmployeePhoneNo()+"', '"+employee.getEmployeeCNIC()+"', '"+employee.getEmployeeAddress()+"', '"+employee.getEmployeeActiveYN()+"','"+employee.getEmployeeSalary()+"');";
		statement.executeUpdate(query);

		
	}

}
