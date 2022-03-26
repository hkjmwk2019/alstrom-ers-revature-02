<%@page import="com.training.ers.dao.ReimburseUploadDAOImpl"%>
<%@page import="com.training.ers.dao.ReimburseUploadDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rejected the Reimbursement</title>
</head>
<body>
  <%
  int reimburseId;
  //Connection con= DBConnection.getConnection();
  reimburseId = Integer.parseInt(request.getParameter("ReimburseId"));
  
  ReimburseUploadDAO reimburseUploadDAO = new ReimburseUploadDAOImpl();
  
	boolean applicationstatus= reimburseUploadDAO.rejectReimburseById(reimburseId);
	//Iterator<Reimbursement> iterator = reimbursements.iterator();
  

%>

  <h2> The reimbusement application is rejected. </h2>
  <h2> The employee application Id is : <%= reimburseId %> </h2>
  
  <br/>
  <br/>
   <a href= "searchReimburseByStatusResult02.jsp">Reimburement Application Page</a> 
  
  
</body>
</html>