package com.mindtree.employee_info_app.dao;

import java.util.List;
import java.util.Set;

import com.mindtree.employee_info_app.entity.Department;
import com.mindtree.employee_info_app.entity.Employee;

public interface DeptDao {
	public String createDepartment(); 
	public String addEmployeeToDepartment(Employee emp, Department dept);
	public String removeEmployeeFromDepartment(Employee emp, Department dept);
	public List<Employee> getEmployeesbyDepartment();
	public Department getDeptByName(String dname);
	public Department getDeptById(int nextInt);
	public String SwitchEmployeeDepartment(Employee emp,Department oldDept, Department newDept);
}
