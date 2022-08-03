package com.amdocs.myapp.dao;
import java.util.List;
import com.amdocs.myapp.entity.*;

public interface EmployeeDAO {

	public boolean addEmployee(Employee employee);
	public boolean deleteEmployee(int emp_id);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployee(int emp_id);
	public List<Employee> getAllEmployees();
	
}
