<%@page import="com.training.ers.dao.ReimburseUploadDAOImpl"%>
<%@page import="com.training.ers.dao.ReimburseUploadDAO"%>
<%@page import="com.training.pms.utility.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approved the Reimbursement </title>
</head>
<body>
<%
  int reimburseId;
  Connection con= DBConnection.getConnection();
  reimburseId = Integer.parseInt(request.getParameter("ReimburseId"));
  
  ReimburseUploadDAO reimburseUploadDAO = new ReimburseUploadDAOImpl();
  
	boolean applicationstatus= reimburseUploadDAO.approveReimburseById(reimburseId);
	//Iterator<Reimbursement> iterator = reimbursements.iterator();
  

%>

  <h2> This is the approve Reimburse button</h2>
  <h2> The employee application Id is : <%= reimburseId %> </h2>
  
  <br/>
  <br/>
  <a href= "searchReimburseByStatusResult02.jsp">Reimburement Application Page</a> 
  <br/>

</body>
</html>