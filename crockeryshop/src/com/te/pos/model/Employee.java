package com.te.pos.model;

public class Employee {
	
	private Long employeeId;
	private String employeeName;
	private String employeePhoneNo;
	private String employeeCNIC;
	private String employeeAddress;
	private String employeeActiveYN;
	private String employeeSalary;
	
	public Employee(Long employeeId, String employeeName, String employeePhoneNo, String employeeCNIC,
			String employeeAddress, String employeeActiveYN, String employeeSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePhoneNo = employeePhoneNo;
		this.employeeCNIC = employeeCNIC;
		this.employeeAddress = employeeAddress;
		this.employeeActiveYN = employeeActiveYN;
		this.employeeSalary = employeeSalary;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhoneNo() {
		return employeePhoneNo;
	}

	public void setEmployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}

	public String getEmployeeCNIC() {
		return employeeCNIC;
	}

	public void setEmployeeCNIC(String employeeCNIC) {
		this.employeeCNIC = employeeCNIC;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeActiveYN() {
		return employeeActiveYN;
	}

	public void setEmployeeActiveYN(String employeeActiveYN) {
		this.employeeActiveYN = employeeActiveYN;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	

}
