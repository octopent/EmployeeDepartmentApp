package com.mindtree.employee_info_app.entity;

public class Employee {
	
	private int empNo;
	private String empName; 
	private String email;
	private String date; 
	private double salary;	
	
	public Employee() {
		super();
	}


	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "\nEmployee: \t\t" + empNo + "\t" + empName + "\t" + email + "\t" + date + "\t"
				+ salary;
	}
	
	
}
