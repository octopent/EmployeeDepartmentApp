package com.mindtree.employee_info_app.dao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.employee_info_app.entity.Department;
import com.mindtree.employee_info_app.entity.Employee;
import com.mindtree.employee_info_app.utility.UtilityTools;

public class DeptDaoImpl implements DeptDao {

	Department department;
	Employee employee;
	EmpDao empDaoObj = new EmpDaoImpl();
	List<Employee> empList = new LinkedList<>(); 
	Scanner sc = new Scanner(System.in);
	@Override
	
	public String createDepartment() {
		department = new Department();
		System.out.println("Enter dept no: ");
		department.setDno(sc.nextInt());
		System.out.println("Enter dept name: ");
		department.setDeptName(sc.next());
		
		//department.setEmployees(empList);
		
		Session session = UtilityTools.createConnection();
		Transaction txn = session.beginTransaction();
		session.save(department);
		txn.commit();
		return "Success";
	}

	@Override
	public String addEmployeeToDepartment(Employee emp, Department dept) {
		dept.getEmployees().add(emp);

		Session session = UtilityTools.createConnection();
		Transaction txn = session.beginTransaction();
		session.merge(department);
		txn.commit();
		return "Success";
	}
	
	@Override
	public String removeEmployeeFromDepartment(Employee emp, Department dept) {
		Session session = UtilityTools.createConnection();
		Transaction txn = session.beginTransaction();
		
		dept.getEmployees().forEach(var->{
			
			if(var.getEmpNo()==emp.getEmpNo()) {
				dept.getEmployees().remove(var);
				session.merge(department);	
			}
		});
		txn.commit();
		return "Removed "+ emp.getEmpName();

	}

	@Override
	public List<Employee> getEmployeesbyDepartment() {
		Session session = UtilityTools.createConnection();
		Transaction txn = session.beginTransaction();

		Query query = session.createQuery("from Employee where dno= :id");
		System.out.println("Enter department id: ");
		query.setInteger("id",sc.nextInt());
		
		empList = (List<Employee>)query.getResultList();
		txn.commit();
		return empList;
	}

	@Override
	public Department getDeptByName(String dname) {
		Session session = UtilityTools.createConnection();
		Transaction txn = session.beginTransaction();

		Query query = session.createQuery("from Department where deptname= :name");
		query.setString("name",dname);
		
		department = (Department) query.uniqueResult();
		txn.commit();
		return department;
	}

	@Override
	public Department getDeptById(int deptId) {
		Session session = UtilityTools.createConnection();
		Transaction txn = session.beginTransaction();

		Query query = session.createQuery("from Department where dno= :id");
		query.setInteger("id",deptId);
		
		department = (Department) query.uniqueResult();
		txn.commit();
		return department;
	}

	@Override
	public String SwitchEmployeeDepartment(Employee emp, Department oldDept, Department newDept) {
		oldDept.getEmployees().remove(emp); 
		newDept.getEmployees().add(emp);
		
		Session session = UtilityTools.createConnection();
		Transaction txn = session.beginTransaction();
		
		session.merge(newDept);
		txn.commit();
		return "Success";
	}

}
