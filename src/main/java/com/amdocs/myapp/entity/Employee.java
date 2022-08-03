package com.amdocs.myapp.entity;

import java.util.Objects;

public class Employee implements Comparable<Employee>{

	private int emp_id;
	private String emp_name;
	private String emp_email;
	private int emp_salary;
	
	public Employee() {}

	public Employee(int emp_id, String emp_name, String emp_email, int emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_salary = emp_salary;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public int getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}
	
	public String toString() {
		return emp_id+"|"+emp_email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emp_email, emp_id, emp_name, emp_salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(emp_email, other.emp_email) && emp_id == other.emp_id
				&& Objects.equals(emp_name, other.emp_name) && emp_salary == other.emp_salary;
	}

	@Override
	public int compareTo(Employee o) {
		if(this.emp_salary > o.emp_salary)
			return 1;
		else if(this.emp_salary < o.emp_salary)
			return -1;
		else
			return 0;
	}
	
}
