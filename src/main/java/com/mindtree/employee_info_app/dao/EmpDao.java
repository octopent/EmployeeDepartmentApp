package com.mindtree.employee_info_app.dao;

import com.mindtree.employee_info_app.entity.Employee;

public interface EmpDao {
	public String addEmployee(Employee employee);
	public Employee getEmployee(int empNo);
	public String deleteEmployee(int empNo);
	public String updateEmployee(Employee employee);
}
