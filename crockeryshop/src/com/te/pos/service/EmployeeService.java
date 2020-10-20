package com.te.pos.service;

import java.sql.SQLException;
import java.util.List;
import com.te.pos.dao.EmployeeDAO;
import com.te.pos.model.Employee;

public class EmployeeService {
	
	public List<Employee> getAllEmployee() throws SQLException{
		
		return new EmployeeDAO().getAllEmployee();
		
	}
	public void insertEmployee(Employee employee) throws SQLException {
		new EmployeeDAO().insertEmployee(employee);
		
	}

}
