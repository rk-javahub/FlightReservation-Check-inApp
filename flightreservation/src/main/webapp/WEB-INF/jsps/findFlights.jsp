<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
</head>
<body>
	<h2>Find Flights</h2>
	<form action="findFlights" method="post">
		From:<input type="text" name="from" /> 
		To:<input type="text" name="to" /> 
		Departure Date:<input type="text" name="departureDate" id="departureDate"/>
		<input type="submit" value="Search" />
	</form>
	<script
		src="webjars/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>

	<script type="text/javascript">
		$('#departureDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
</body>
</html>