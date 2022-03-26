<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css"  rel="stylesheet" href="styles.css" >
</head>
<body>
	<h1> Hello and Welcome to JSP </h1>
	
	<%
		String guestName;
		guestName= request.getParameter("gname");
		for (int i=1; i<=5; i++){
	%>aaa<br>
	
  <h1> Revature </h1>
  
	<%
	}
	%>
	
<% out.println("Welcome : " + guestName); 
%>

<br/>
<%="Welcome : "+ guestName %>

</body>
</html>