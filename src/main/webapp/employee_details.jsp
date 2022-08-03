<%@page import="com.amdocs.myapp.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Employee Details</h2>
	<%
		List<Employee> emps = (List<Employee>)request.getAttribute("emps");
	%>
	
	<table>
		<tr>
			<th>EmpID</th><th>EmpName</th><th>EmpEmail</th><th>EmpSalary</th>
		</tr>
		<%
			for(Employee emp : emps){
		%>
		<tr>
			<td><%=emp.getEmp_id() %></td>
			<td><%=emp.getEmp_name() %></td>
			<td><%=emp.getEmp_email() %></td>
			<td><%=emp.getEmp_salary() %></td>
		</tr>	
		<%
			} 
		%>
	</table>
	<a href="index.jsp">Main Page</a>
</body>
</html>