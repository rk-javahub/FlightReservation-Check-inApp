<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Register User</title>
<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/registrationForm.css" rel="stylesheet" type="text/css">
</head>
<body>

	<form action="registerUser" method="post">
		<div class="container" align="left">
			<h1 align="center">Register</h1>
			<p align="center">Please fill in this form to create an account.</p>
			<hr>

			<label for="firstname"><b>First Name</b></label> <input type="text"
				name="firstName" placeholder="Enter First Name" id="firstname"
				required="required" /><br /> <label for="lastname"><b>Last
					Name:</b></label> <input type="text" name="lastName"
				placeholder="Enter Last Name" id="lastName" required="required" /><br />
			<label for="username"><b> User Name:</b> </label><input type="text"
				name="email" placeholder="Enter Email" id="email"
				required="required" /><br /> <label for="password"><b>Password:</b></label>
			<input type="password" name="password" placeholder="Enter Password"
				id="password" required="required" /><br /> <label
				for="confirm password"><b>Confirm password:</b></label> <input
				type="password" name="Confirm Password"
				placeholder="Enter Password once again" id="password repeat"
				required="required" /><br /> <br />
			<hr>
			<p>
				By creating an account you agree to our <a href="terms_and_conditions.html" target="_blank">Terms &
					Privacy</a>.
			</p>
			<input type="submit" class="registerbtn" value="Register" /><br />
		</div>
		<div class="container signin">
			<p>
				Already have an account? <a href="loginpage">Sign in</a>.
			</p>
		</div>

	</form>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>