<%@page import="com.training.ers.model.EmployeeUser"%>
<%@page import="com.training.ers.dao.EmployeeLoginDAOImpl"%>
<%@page import="com.training.ers.dao.EmployeeLoginDAO"%>
<%@page import="com.training.ers.dao.LoginDAOImpl"%>
<%@page import="com.training.ers.dao.LoginDAO"%>
<%@page import="java.util.Iterator" %>
<%@page import="com.training.ers.model.User" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

	
	<% String username= (String)session.getAttribute("username");  %>

	<h2>
		
		You are search the   : <%= username %> and the message is: <%= session.getAttribute("message") %>
	</h2>

<body>
	<% 
		EmployeeLoginDAO employeeloginDAO=new EmployeeLoginDAOImpl();
		List<EmployeeUser> employeeusers= employeeloginDAO.getEmployeeUsers();         
		Iterator<EmployeeUser> iterator = employeeusers.iterator();		
	%>	
	
	<h1> List of all the users</h1>
	
	<!--  display all the users   -->
	<table class="table table-striped table-bordered"  border="2" cellspacing="10" cellpadding="10">
	 	<thead>
			<th>User Id</th> 
			<th>User Name</th> 
			<th>Password</th>
			<th>Gender</th>
			<th>Notifications</th>
			<th>Qualification</th>	
		 </thead>
		 
		 <tbody>
	<%
		while(iterator.hasNext()){
			EmployeeUser employeeuser = iterator.next();
			
			out.print(employeeuser);	
			out.print("\n");
	%>
		<tr>
			<td><%= employeeuser.getUserId() %></td>
			<td><%= employeeuser.getUsername() %></td>
			<td><%= employeeuser.getPasswords() %></td>
			<td><%= employeeuser.getGender() %></td>
			<td><%= employeeuser.getNotifications() %></td>
			<td><%= employeeuser.getQualification() %></td>
		</tr>
		</tbody>
	<%
		}
	%>
	
	</table>
	
	<br/>
	<br/>
	<a href= "welcome.jsp">Back to Welcome Managers Home Page</a> 
	<br/>
</body>
</html>