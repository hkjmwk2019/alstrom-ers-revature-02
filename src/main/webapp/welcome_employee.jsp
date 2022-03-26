<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Employees</title>
<link type="text/css"  rel="stylesheet" href="styles.css" >
</head>

<%
	// get session attribute which is set in EmployeeSignInController.java
	String employeename = (String)session.getAttribute("employeename");  	
   
%>
	 	
<body>
	<h2 align="left">Employee Web Page</h2>
	 <h2 align="left">You are logged in as : <%= employeename %> </h2>
	<br/>
	<br/>
	<a href="employeepasswordchange.html"> password change</a> |
	<a href="searchReimburseByEmployeeResults.jsp">Search Your Reimbursement</a> |
	<a href="reimburse.jsp">Fill Your Reimburse Form</a> |
	<a href="index.jsp">Logout</a>
	<br/>

</body>
</html>