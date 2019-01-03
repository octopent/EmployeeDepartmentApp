package com.mindtree.employee_info_app.dao;

import org.hibernate.Transaction;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mindtree.employee_info_app.entity.Employee;
import com.mindtree.employee_info_app.utility.UtilityTools;

public class EmpDaoImpl implements EmpDao {
	
	Employee employee;
	Scanner sc = new Scanner(System.in);
	@Override
	public String addEmployee(Employee employee) {
		System.out.println("ENTER EMPLOYEE DETAILS: ");
//		System.out.println("employee id: ");
//		employee.setEmpNo(sc.nextInt());
		System.out.println("employee name: ");
		employee.setEmpName(sc.next());
		System.out.println("employee email: ");
		employee.setEmail(sc.next());
		System.out.println("employee date: ");
		employee.setDate(sc.next());
		System.out.println("employee salary: ");
		employee.setSalary(sc.nextDouble());
		
		Session session = UtilityTools.createConnection(); 
		Transaction txn = (Transaction) session.beginTransaction(); 
		session.save(employee);
		txn.commit();
		return "Success!";
	}

	@Override
	public Employee getEmployee(int emplNo) {
		Session session = UtilityTools.createConnection(); 
		Transaction txn = (Transaction) session.beginTransaction(); 
		
		Query query = session.createQuery("from Employee where empNo= :eno");
		query.setParameter("eno", emplNo); 
		
		employee = (Employee) query.uniqueResult();
		txn.commit();
		
		return employee;	
	}

	@Override
	public String deleteEmployee(int emplNo) {
		Session session = UtilityTools.createConnection(); 
		Transaction txn = (Transaction) session.beginTransaction(); 
		
		Query query = session.createQuery("delete Employee where empNo= :eno");
		query.setParameter("eno", emplNo); 
		
		int ctr = query.executeUpdate();
		txn.commit();
		
		if(ctr>0) {
			return "success!";
		}
		return null;
	}

	@Override
	public String updateEmployee(Employee employee) {	
		Session session = UtilityTools.createConnection(); 
		Transaction txn = (Transaction) session.beginTransaction(); 
		System.out.println("Enter new name: ");

		Query query = session.createQuery("update Employee set empname =:newname where empNo= :eno");
		query.setParameter("newname", sc.next()); 
		
		query.setParameter("eno", employee.getEmpNo()); 
		
		int ctr = query.executeUpdate();
		txn.commit();
		
		if(ctr>0) {
			return "success and all";
		}
		return null;
	}

}
