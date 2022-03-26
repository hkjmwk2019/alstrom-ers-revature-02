<%@page import="com.training.ers.dao.EmployeeLoginDAOImpl"%>
<%@page import="com.training.ers.model.EmployeeUser"%>
<%@page import="com.training.ers.dao.EmployeeLoginDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.training.ers.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.LoginDAOImpl"%>
<%@page import="com.training.ers.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="styles.css">
</head>
	<%
	// get session attribute which is set in SignInController.java
	String username = (String)session.getAttribute("username");  
	
	String searchthename = request.getParameter("searchthename");
	%>
		
	 <h2>You are logged in as : <%= username %> and the message is : <%= session.getAttribute("message") %></h2>
	<h2>You are searching : <%= searchthename %> and the message is : <%= session.getAttribute("message") %></h2>

<body>
	<!-- below not use List<User> users= LoginDAOImpl.getUsers();  -->
	<% 
	EmployeeLoginDAO employeeloginDAO = new EmployeeLoginDAOImpl();
	List<EmployeeUser> employeeusers = employeeloginDAO.getUsersByEmployeeUserName(searchthename);
						
	Iterator<EmployeeUser> iterator = employeeusers.iterator();
		
	%>	
	
	<h1> List of the user you searched</h1>
	<table border="2" cellspacing="10" cellpadding="10">
		<th>User Id</th> 
		<th>User Name</th> 
		<th> Password</th>
		<th>Gender</th>
		<th>Notifications</th>
		<th>Qualification</th>	
	<%
		while(iterator.hasNext()){
			EmployeeUser employeeuser = iterator.next();
			out.println(employeeuser);		
	%>
		<tr>
			<td><%= employeeuser.getUserId() %></td>
			<td><%= employeeuser.getUsername() %></td>
			<td><%= employeeuser.getPasswords() %></td>
			<td><%= employeeuser.getGender() %></td>
			<td><%= employeeuser.getNotifications() %></td>
			<td><%= employeeuser.getQualification() %></td>
		</tr>
		
	<%
		}
	%>
	
	</table>
	
	<br/>
	<br/>
	<a href= "welcome.jsp"> Back to Welcome Managers Home Page</a> 
	<br/>

</body>
</html>