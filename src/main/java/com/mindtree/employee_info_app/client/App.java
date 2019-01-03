package com.mindtree.employee_info_app.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.employee_info_app.dao.DeptDao;
import com.mindtree.employee_info_app.dao.DeptDaoImpl;
import com.mindtree.employee_info_app.dao.EmpDao;
import com.mindtree.employee_info_app.dao.EmpDaoImpl;
import com.mindtree.employee_info_app.entity.Department;
import com.mindtree.employee_info_app.entity.Employee;
import com.mindtree.employee_info_app.utility.UtilityTools;

public class App 
{
	EmpDao empDaoObj = new EmpDaoImpl();
	DeptDao deptDaoObj = new DeptDaoImpl();
	
    public static void main( String[] args )
    {    	
    	Scanner sc = new Scanner(System.in);

		EmpDao empDaoObj = new EmpDaoImpl();
		DeptDao deptDaoObj = new DeptDaoImpl();
	
		MenuPrinter.printHeader();

		int choice = 0; 
		while(choice != 10) {
			MenuPrinter.printMenu();
			choice = sc.nextInt(); 

			switch(choice) {
			case 1: { 
				empDaoObj.addEmployee(new Employee());
				break; 
			}
			case 2: { 
				System.out.println("Enter employee number: ");
				System.out.println(empDaoObj.getEmployee(sc.nextInt()));
				break; 
			}
			case 3: { 
				System.out.println("Enter employee number: ");
				System.out.println(empDaoObj.deleteEmployee(sc.nextInt()));
				break; 
			}
			case 4: { 
				System.out.println("Enter emp no: ");
				System.out.println(
				empDaoObj.updateEmployee(empDaoObj.getEmployee(sc.nextInt()))
						);
				break; 
			}
			case 5: { 
				System.out.println(deptDaoObj.createDepartment());
				break; 
			}
			case 6: { 
				System.out.println("Enter emp id: ");
				Employee emp = empDaoObj.getEmployee(sc.nextInt());
				System.out.println("Enter dept id: ");
				Department dept = deptDaoObj.getDeptById(sc.nextInt());
				System.out.println(deptDaoObj.addEmployeeToDepartment(emp, dept));
				break; 
			}
			case 7: { 
				System.out.println("Enter emp id: ");
				Employee emp = empDaoObj.getEmployee(sc.nextInt());
				
				System.out.println("Enter emp dept: ");
				Department dept = deptDaoObj.getDeptById(sc.nextInt());
				
				System.out.println(deptDaoObj.removeEmployeeFromDepartment(emp, dept));
				break; 
			}
			case 8: {
				deptDaoObj.getEmployeesbyDepartment().forEach(System.out::println);
				break; 
			}
			case 9: {
				System.out.println("Enter emp id: ");
				Employee emp = empDaoObj.getEmployee(sc.nextInt());
				
				System.out.println("Enter old dept: ");
				Department oldDept = deptDaoObj.getDeptById(sc.nextInt());
				
				System.out.println("Enter new dept: ");
				Department newDept = deptDaoObj.getDeptById(sc.nextInt());
				
				System.out.println(deptDaoObj.SwitchEmployeeDepartment(emp, oldDept, newDept));
				break;
			}
			case 10: {
				System.err.println("Exiting App... \n App Terminated");
				break;
			}
			default: { 
				System.out.println("INVALID RESPONSE!!!");
				break; 
			}

			}

		}
    }
}
