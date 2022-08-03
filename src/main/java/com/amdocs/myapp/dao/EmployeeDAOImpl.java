package com.amdocs.myapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.myapp.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "SYSTEM";
	String password = "root";
	String driverClass = "oracle.jdbc.driver.OracleDriver";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	@Override
	public boolean addEmployee(Employee employee) {
		boolean employeeAdded = false;
		try {
			//STEP 1: load the driver class & get the connection object
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		
			//STEP 2: create or prepare the statement object
			String sql = "INSERT INTO emp (emp_name, emp_email, emp_salary) VALUES (?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, employee.getEmp_name());
			pst.setString(2, employee.getEmp_email());
			pst.setInt(3, employee.getEmp_salary());
			
			int rowAffected = pst.executeUpdate();
			
			if(rowAffected > 0)
				employeeAdded = true;
			
			pst.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println("Problem in loading driver class");
		}catch(SQLException e) {
			System.out.println("Problem in getting the connection object..");
		}
		return employeeAdded;
	}

	@Override
	public boolean deleteEmployee(int emp_id) {
		boolean employeeDeleted = false;
		try {
			//STEP 1: load the driver class & get the connection object
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		
			//STEP 2: create or prepare the statement object
			String sql = "DELETE from emp WHERE emp_id=?";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, emp_id);
			
			int rowAffected = pst.executeUpdate();
			
			if(rowAffected > 0)
				employeeDeleted = true;
			
			pst.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println("Problem in loading driver class");
		}catch(SQLException e) {
			System.out.println("Problem in getting the connection object..");
		}
		return employeeDeleted;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updatedEmployee = null;
		
		try {
			//STEP 1: load the driver class & get the connection object
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		
			//STEP 2: create or prepare the statement object
			String sql = "UPDATE emp SET emp_name=?, emp_email=?, emp_salary=? WHERE emp_id=?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, employee.getEmp_name());
			pst.setString(2, employee.getEmp_email());
			pst.setInt(3, employee.getEmp_salary());
			pst.setInt(4, employee.getEmp_id());
			
			int rowAffected = pst.executeUpdate();
			
			if(rowAffected > 0)
				updatedEmployee = getEmployee(employee.getEmp_id());
			
			pst.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println("Problem in loading driver class");
		}catch(SQLException e) {
			System.out.println("Problem in getting the connection object..");
		}
		
		return updatedEmployee;
	}

	@Override
	public Employee getEmployee(int emp_id) {
		Employee employee = null;
		
		try {
			//STEP 1: load the driver class & get the connection object
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		
			//STEP 2: create or prepare the statement object
			String sql = "SELECT * FROM emp WHERE emp_id=?";
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, emp_id);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				employee = new Employee();
				employee.setEmp_id(rs.getInt("emp_id"));
				employee.setEmp_name(rs.getString("emp_name"));
				employee.setEmp_email(rs.getString("emp_email"));
				employee.setEmp_salary(rs.getInt("emp_salary"));
			}
			
			rs.close();
			pst.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
			List<Employee> employees = new ArrayList<Employee>();
			Employee employee = null;
		
		try {
			//STEP 1: load the driver class & get the connection object
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		
			//STEP 2: create or prepare the statement object
			String sql = "SELECT * FROM emp";
			stmt = conn.createStatement();
		
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				employee = new Employee();
				employee.setEmp_id(rs.getInt("emp_id"));
				employee.setEmp_name(rs.getString("emp_name"));
				employee.setEmp_email(rs.getString("emp_email"));
				employee.setEmp_salary(rs.getInt("emp_salary"));
				
				employees.add(employee);
			}
			
			rs.close();
			//pst.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	
}
