package com.mindtree.employee_info_app.client;

public class MenuPrinter {
	public static void printHeader() {
		System.out.println("---------------------------------------------------");
		System.out.println("------------- WELCOME TO EMPLOYEE APP -------------");
		System.out.println("---------------------------------------------------");
	}
	
	public static void printMenu() {
		
		System.out.println("1. Add Employee \n"
				+ "2. View Employees \n"
				+ "3. Delete Employees \n"
				+ "4. Update Employees \n"
				
				+ "5. Add Department \n"
				+ "6. Add Employee to Department \n"
				+ "7. Remove Employee from Department Id\n"
				+ "8. Get Employees by Department \n"
				+ "9. Switch Department \n"
				+ "10. Exit App \n"
				+ "Enter your choice: " );
	}
}
