<%@page import="java.util.Iterator"%>
<%@page import="com.training.ers.dao.ReimburseUploadDAOImpl"%>
<%@page import="com.training.ers.model.Reimbursement"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.ReimburseUploadDAO"%>
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


	<% String username= (String)session.getAttribute("username"); %>
	
		
<body>

<%
        ReimburseUploadDAO reimburseUploadDAO=new ReimburseUploadDAOImpl();
		  
		List<Reimbursement> reimbursements= reimburseUploadDAO.getReimburseByStatus("pending");
		Iterator<Reimbursement> iterator = reimbursements.iterator();
%>	

<h1> List of all the Reimbursments</h1>
	
	<!--  display all the users   -->
	<table class="table table-striped table-bordered"  border="2" cellspacing="10" cellpadding="10">
	 	<thead>
			<th>ReimburseId</th> 
			<th>Employeen Name</th> 
			<th>Hotel Cost</th>
			<th>Airplane Ticket Cost</th>
			<th>Rent Car Cost</th>
			<th>Reimburse Applicattion Status</th>	
			<th> Approve Application </th>
			<th> Reject Application </th>
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
			
			
			
			
			<td>
				<button type="button" class="btn btn-warning"> <a href= "approveReimbursement.jsp?ReimburseId=<%= reimbursement.getReimburseId()%>"> Approve</a></button>
			</td>
			
			<td>
				<button type="button" class="btn btn-warning"> <a href= "rejectReimbursement.jsp?ReimburseId=<%= reimbursement.getReimburseId()%>"> Reject</a></button>
			</td>	
			
			
	</tr>
		</tbody>
		 
	<%
		}
	%>	
	
</table>
	
	<br/>
	<br/>
	<a href= "welcome.jsp">Managers Home Page</a> 
	<br/>


</body>
</html>