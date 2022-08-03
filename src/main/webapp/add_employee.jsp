<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Add Employee Page</h2>

<%
	boolean empAdded = Boolean.parseBoolean(request.getParameter("empAdded"));
%>

<%
	if(empAdded){
%>
	<i><b><center>Employee Added Successfully</center></b></i>
<%		
	}
%>

<form name="add_emp_form" action="addNewEmp" method="POST">
	<input type="text" name="emp_name" placeholder="Employee Name"><br>
	<input type="email" name="emp_email" placeholder="Email here"><br>
	<input type="number" name="emp_salary" placeholder="Salary"><br>
	<input type="submit" value="Add Employee">
</form>

</body>
</html>