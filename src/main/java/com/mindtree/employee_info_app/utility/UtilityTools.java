package com.mindtree.employee_info_app.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.employee_info_app.entity.Department;
import com.mindtree.employee_info_app.entity.Employee;

public class UtilityTools {
	
	public static Session createConnection() {
		Configuration configuration = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class);
		SessionFactory sf = configuration.buildSessionFactory(); 
		Session session = sf.openSession(); 
		return session;
	}
}
