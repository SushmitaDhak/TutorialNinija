package com.EmployeMngt;

import java.util.Scanner;

public class Main {
	EmployeeService service = new EmployeeService();
	static boolean ordering = true;
	 public static void menu() {
        System.out.println("******Welcome To Employee Managment Ststem********"+"\n1.Add Employee"+"\n2.View Employee"+"\n3.Update Employee"+"\n4.Delete Employee"+"\n5.View All Employee"+"\n6.Exist");
	
	 }
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		EmployeeService service = new EmployeeService();
		do {
		    menu();
			System.out.println("Enter Your Choice ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1 :
				System.out.println("Add Employee");
				break;
			case 2 :
				System.out.println("View Employee");
				service.viewemp();
				break;
			case 3 :
				System.out.println("Update Employee");
				service.updateEmployee();
				break;
			case 4 :
				System.out.println("Delete Employee");
				service.deleteEmp();
				break;
			case 5 :
				System.out.println("View All Employee");
				service.viewAllEmps();
				break;
			case 6 :
				System.out.println("Thanking For Using Application");
				System.exit(0);
				break;
			default :
				System.out.println("Please Enter Valid Choice");
				System.exit(0);
				break;
			
			}
		}
		while(ordering );
	//		
	}

}
