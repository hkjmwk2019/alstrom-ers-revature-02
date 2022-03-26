<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reimbursement Form Information reimburse.jsp</title>
	<link type="text/css" rel="stylesheet" href="styles.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script type = "text/javascript" src= "js/jquery-3.4.4.min.js"> </script>

</head>
<%
	// get session attribute which is set in EmployeeSignInController.java
	String employeename = (String)session.getAttribute("employeename");  	
    String employeepasswords = (String)session.getAttribute("employeepasswords");  	
%>

 
	 <h2>You are logged in as : <%= employeename %> </h2>
	

<script type="text/javascript">

	function validateSignUpForm() {
	//	var uname1 = document.getElementById("username").value;
	//	var uname2 = document.signupform.username.value;
	//	var pwd = document.forms[0].elements[1].value;
	//	var confirmpwd = document.forms[0].elements[2].value;

	//	var checked1 = document.getElementById('email').checked
	//	var checked2 = document.getElementById('sms').checked
	//	var checked3 = document.getElementById('courier').checked

		//var qual = document.signupform.qualification.options.selectedIndex;
	   
		var hotelCost_temp    = document.getElementById("reimburseHotel").value;
		var airplaneCost_temp = document.getElementById("reimburseAirplaneticket").value;
		var rentCarCost_temp  = document.getElementById("reimburseRentCar").value.
		
		
		int hotelCost= Integer.parseInt(hotelCost_temp);
		int airplaneCost= Integer.parseInt(airplaneCost_temp);
		int rentCarCost= Integer.parseInt(rentCarCost_temp);
		
		
		if (hotelCost == 0 ||  airplaneCost == 0 || rentCarCost == 0) {
			alert("Please fill your Cost. ");
			return false;
		

	}

	
</script>

<body>

	<form class="form-style" action="UploadController02" onsubmit="return validateSignUpForm()" name="signupform" method ="get">

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
			
			<tr>
				<td><input type="submit" value="SignUp"  class= "btn btn-primary"></td>
				<td><input type="reset" value="Clear"  class= "btn btn-warning" ></td>
			</tr>

	</table>
	
	
	</form>

<br/>


</body>
</html>