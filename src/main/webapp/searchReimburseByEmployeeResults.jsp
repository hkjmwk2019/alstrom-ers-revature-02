<%@page import="java.util.Iterator"%>
<%@page import="com.training.ers.model.Reimbursement"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.ReimburseUploadDAOImpl"%>
<%@page import="com.training.ers.dao.ReimburseUploadDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Your Reimbursement List</title>
	<link type="text/css" rel="stylesheet" href="styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script type = "text/javascript" src= "js/jquery-3.4.4.min.js"> </script>

	
	
</head>

	<% String employeename= (String)session.getAttribute("employeename"); %>
		
	<h2>
		
	 Your name is  : <%=employeename%> and the message is: <%=session.getAttribute("message")%>
	</h2>
	
<body>

<%
		ReimburseUploadDAO reimburseUploadDAO=new ReimburseUploadDAOImpl();
		List<Reimbursement> reimbursements= reimburseUploadDAO.getReimburseByEmployeeName(employeename) ;
		Iterator<Reimbursement> iterator = reimbursements.iterator();
%>	

<h1> List of all the Reimbursments</h1>
	
	<!--  display all the users   -->
	<table class="table table-striped table-bordered"  border="2" cellspacing="10" cellpadding="10">
	 	<thead>
			<th>ReimburseId</th> 
			<th>Employee Name</th> 
			<th>Hotel Cost</th>
			<th>Airplane Ticket Cost</th>
			<th>Rent Car Cost</th>		<th>Reimburse Applicattion Status</th>	
		 </thead>	 
		 <tbody>
	<% 
		while(iterator.hasNext()){
			Reimbursement reimbursement = iterator.next();
		
			// out.print(reimbursement);	
			//out.print("\n");
			
	%>
			
	<tr>
			<td><%= reimbursement.getReimburseId()        %></td>
			<td><%= reimbursement.getEmployeename()       %></td>
			<td><%= reimbursement.getReimburseHotel()     %></td>
			<td><%= reimbursement.getReimburseAirplaneticket() %></td>
			<td><%= reimbursement.getReimburseRentCar()  %></td>
			<td><%= reimbursement.getStatus() %></td>
		</tr>
		</tbody>
		 
	<%
		}
	%>	
	
</table>
	
	<br/>
	<br/>
	<a href= "welcome_employee.jsp">Back to Welcome Employee Home Page</a> 
	<br/>

</body>
</html>