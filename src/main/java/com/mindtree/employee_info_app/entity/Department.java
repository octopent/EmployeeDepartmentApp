package com.mindtree.employee_info_app.entity;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private int dno;
	private String deptName;
	private Set<Employee> employees = new HashSet<>();
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Department() {
		super();
	}
	
	@Override
	public String toString() {
		return "Department: \t" + dno + "\t" + deptName + "\t" + employees + "]";
	}
	
	
}
