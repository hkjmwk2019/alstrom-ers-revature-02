<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Employees</title>
<link type="text/css" rel="stylesheet" href="styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script type = "text/javascript" src= "js/jquery-3.4.4.min.js"> </script>



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