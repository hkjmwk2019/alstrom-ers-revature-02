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
<title>The Reimbursement Detail</title>
<link type="text/css" rel="stylesheet" href="styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script type = "text/javascript" src= "js/jquery-3.4.4.min.js"> </script>

</head>
<body>
	<%
		  String reimbursename = request.getParameter("reimbursename");
			// set sesssion Attribute , name it username 
			//HttpSession session = request.getSession();
		
			session.setAttribute("applicantname", reimbursename);
	
	%>
	<br/>
 		<a href= "welcome.jsp">Back To Manager Page</a> 
 	<br/>
	
	<h2 align="left" > The reimbursment application submitted  by <%= reimbursename %> .</h2>
	
	
	<!-- below not use List<Reimburse> users= LoginDAOImpl.getUsers();  -->
	<% 
	  	ReimburseUploadDAO reimburseUploadDAO=new ReimburseUploadDAOImpl();
	  
		List<Reimbursement> reimbursements= reimburseUploadDAO.getReimburseByEmployeeName(reimbursename);
				;
		Iterator<Reimbursement> iterator = reimbursements.iterator();
		
	%>	
	
	<h2 align= "left" >List The Employee's Reimbursement Applications</h2>
	
	
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
				<button type="button" class="btn btn-warning"> <a href= "approveReimbursement02.jsp?ReimburseId=<%= reimbursement.getReimburseId()%>"> Approve</a></button>
			</td>
			
			<td>
				<button type="button" class="btn btn-warning"> <a href= "rejectReimbursement02.jsp?ReimburseId=<%= reimbursement.getReimburseId()%>"> Reject</a></button>
			</td>	
			
			
	</tr>
		</tbody>
		 
	<%
		}
	%>	
	
</table>

</body>
</html>