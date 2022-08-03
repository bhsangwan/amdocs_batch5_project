package com.amdocs.myapp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.myapp.dao.EmployeeDAO;
import com.amdocs.myapp.dao.EmployeeDAOImpl;
import com.amdocs.myapp.entity.Employee;


@WebServlet("/addNewEmp")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emp_name = request.getParameter("emp_name");
		String emp_email = request.getParameter("emp_email");
		int emp_salary = Integer.parseInt(request.getParameter("emp_salary"));
		Employee emp = new Employee(0, emp_name, emp_email, emp_salary);
		EmployeeDAO dao =new EmployeeDAOImpl();
		
		if(dao.addEmployee(emp)) {
			response.sendRedirect("add_employee.jsp?empAdded=true");
		}else {
			response.sendRedirect("add_employee.jsp");
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
