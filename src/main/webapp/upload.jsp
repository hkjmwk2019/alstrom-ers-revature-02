<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script type = "text/javascript" src= "js/jquery-3.4.4.min.js"> </script>



</head>

<%
	// get session attribute which is set in SignInController.java
	String username = (String)session.getAttribute("username");  
	
	%>

<body>

<form class="form-style" action="SignUpController" onsubmit="return validateSignUpForm()" name="signupform" method ="post">

<table cellspacing="20" cellpadding="20" bgcolor="cyan">
			<tr>
				<td><label>Reimburse Hotel cost: </label></td>
				<td><input type="text" name="reimburseHotel" id="reimburseHotel"></td>
			</tr>
			<tr>
				<td><label>Reimburse Airplane ticket cost: </label></td>
				<td><input type="text" name="reimburseAirplaneticket" id="reimburseAirplaneticket"></td>
			</tr>
			
			<tr>
				<td><label>reimburse Rent Car cost: </label></td>
				<td><input type="text" name="reimburseRentCar" id="reimburseRentCar"></td>
			</tr>
			
	</table>
	
	<input id= "attchedfile" name= "attachiedfile", type= "file" stype="padding-left: 0px;" >
	<input type="submit" value="SignUp"  class= "btn btn-primary">

</form>
		

</body>

</body>
</html>