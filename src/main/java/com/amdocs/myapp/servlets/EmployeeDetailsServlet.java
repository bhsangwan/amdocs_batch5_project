package com.amdocs.myapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.myapp.dao.EmployeeDAO;
import com.amdocs.myapp.dao.EmployeeDAOImpl;
import com.amdocs.myapp.entity.Employee;

/**
 * Servlet implementation class EmployeeDetailsServlet
 */
@WebServlet("/viewEmps")
public class EmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside View Employee Servlet");
		EmployeeDAO dao = new EmployeeDAOImpl();
		List<Employee> emps = dao.getAllEmployees();
		System.out.println(emps.size());
		request.setAttribute("emps", emps);
		RequestDispatcher dispatch = request.getRequestDispatcher("employee_details.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
