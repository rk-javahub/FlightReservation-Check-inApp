<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Register User</title>
<style>
.error {
	color: red
}
</style>
<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/registrationForm.css" rel="stylesheet" type="text/css">
</head>
<body>

	<form:form action="registerUser" modelAttribute="user">
		<div class="container" align="left">
			<h1 align="center">Register</h1>
			<p align="center">Please fill in this form to create an account.</p>
			<hr>

			<form:label path="firstName">
				<b>First Name</b>
			</form:label>
			<form:input path="firstName" required="required" />
			<form:errors path="firstName" cssClass="text-warning" />
			<br />
			<form:label path="lastName">
				<b>Last Name:</b>
			</form:label>
			<form:input path="lastName" required="required" />
			<br />
			<form:label path="email">
				<b>User Name:</b>
			</form:label>
			<form:input path="email" required="required" />
			<br />
			<form:label path="password">
				<b>Password:</b>
			</form:label>
			<form:input path="password" required="required" />
			<br />
			<label><b>Confirm Password</b></label>
			<input type="text" name="password" required="required" />
			<br /> <br />
			<hr>
			<p>
				By creating an account you agree to our <a
					href="terms_and_conditions.html" target="_blank">Terms &
					Privacy</a>.
			</p>
			<input type="submit" class="registerbtn" value="Register" /><br />
		</div>
		<div class="container signin">
			<p>
				Already have an account? <a href="loginpage">Sign in</a>.
			</p>
		</div>
	</form:form>
	
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>