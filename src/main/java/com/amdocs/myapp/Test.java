package com.amdocs.myapp;

import java.util.List;

import com.amdocs.myapp.dao.EmployeeDAO;
import com.amdocs.myapp.dao.EmployeeDAOImpl;
import com.amdocs.myapp.entity.Employee;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello World..!");
		
		//Employee emp = new Employee(0, "Dimple", "renu@gmail.com", 12300);
		EmployeeDAO dao = new EmployeeDAOImpl();
		/*if(dao.addEmployee(emp))
			System.out.println("Employee added successfully..!");
		else
			System.out.println("Kuchh gdbd ho gayi...!");
		*/
		
		/*if(dao.deleteEmployee(101))
			System.out.println("Employee Deleted");
		else
			System.out.println("Something went wrong..!");
		*/
		
		List<Employee> emps = dao.getAllEmployees();
		
		for(Employee emp : emps) {
			System.out.println(emp);
		}
	}

}
