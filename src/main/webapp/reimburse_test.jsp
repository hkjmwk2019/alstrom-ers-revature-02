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
<body>
<div class="reimburserformpart">
	<form class="form-style" action="UpLoadController" onsubmit="return validateSignUpForm()" name="signupform" method ="get">

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
	</form>
</div>

<div class= "container" >
	<fieldset>
		<legend> add file </legend>
		<form action = "/management?method = create" method="post" autocomplete="off"  enctype="multipart/form-data" >		
			
			<ul class = "ulform">
				<li>
					<span> file name </span>
					<span id="errPname"></span>
				</li>
				
				<li>
					<span> pre-view the file </span>
					<span id= "errPainting" ></span>
					<input id= "painting" name= "painting", type= "file" stype="padding-left: 0px;" accept="image/*">
				</li>

				<li style= "text-align: center;">
					<button type= "submit" class="btn-button"> submit the Form </button>

				</li>
				

</div>
</body>
</html>