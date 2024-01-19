package com.EmployeMngt;

import java.util.HashSet;
import java.util.Scanner;

public class EmployeeService {
	HashSet<Employee> empset = new HashSet<Employee>();
	Employee emp1 = new Employee(101,"Sushmita",24,"IT", "Devloper",25000);
	Employee emp2 = new Employee(102,"Asmita",26,"IT", "Devloper",29000);
	Employee emp3 = new Employee(103,"Mahesh",29,"IT", "Devloper",55000);
	Employee emp4 = new Employee(104,"Mandakini",40,"IT", "Devloper",60000);
	Scanner sc = new Scanner(System.in);
	boolean found=false;
	int id;
	String name ;
	int age;
	String designation;
	String department;
	double salary;
	public EmployeeService() {
		empset.add(emp1);
		empset.add(emp2);
		empset.add(emp3);
		empset.add(emp4);
	}
	//view all Employee
	public void viewAllEmps() {
		for (Employee emp:empset) {
			System.out.println(emp);
		}
	}
	// view emp based on there id
	public void viewemp(){
		System.out.println("Enter id :");
		id= sc.nextInt();
		for(Employee emp : empset) {
			if(emp.getId()==id) {
				System.out.println(emp);
				found=true;
			}
		}
		if(!found) {
			System.out.println("Employee With this ID is Not Present ");
		}
	}
	//update the employee
	public void updateEmployee() {
		System.out.println("Enter id:");
		id=sc.nextInt();
		boolean found = false ;
		for(Employee emp:empset) {
			if(emp.getId()==id) {
				System.out.println("Enter Name :");
				name=sc.next();
				System.out.println("Enter new Salary");
				salary=sc.nextDouble();
				emp.setName(name);
				emp.setSalary(salary);
				System.out.println("Updated Details Of Employee Are : ");
				System.out.println(emp);
				found=true;
			}
		}
		if (!found) {
			System.out.println("Employee Is not present ");
		}
		else {
			System.out.println("Employee Details Updated Successfully  !!");
		}
	}
	// delete employee
	public void deleteEmp() {
		System.out.println("Enter ID ");
		id=sc.nextInt();
		boolean found= false;
		Employee empdelete=null;
		for (Employee emp : empset) {
			if(emp.getId()==id) {
				empdelete=emp;
				found=true;
			}
			if(!found) {
				System.out.println("Employee is not Present ");
			}
			else {
				empset.remove(empdelete);
				System.out.println("Employee Delete Successfully !!");
			}
		}
	}

}
