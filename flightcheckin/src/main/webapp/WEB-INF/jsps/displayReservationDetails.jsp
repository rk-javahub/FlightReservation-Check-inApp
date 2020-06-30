<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>Flight Details</h2>
		Airlines: ${reservation.flight.operatingAirlines} Flight No:
		${reservation.flight.flightNumber} Departure City:
		${reservation.flight.departureCity} Arrival City:
		${reservation.flight.arrivalCity} Date Of Departure:
		${reservation.flight.dateOfDeparture} Estimated Departure Time:
		${reservation.flight.estimatedDepartureTime}

		<h2>Passenger Details</h2>
		First Name:${reservation.passenger.firstName} Last
		Name:${reservation.passenger.lastName}
		Email:${reservation.passenger.email}
		Phone:${reservation.passenger.phone}

		<form action="completeCheckIn" method="post">
			Enter the Number Of Bags you want to Check In:<input type="text"
				name="numberOfbags" /> 
				<input type="hidden" value="${reservation.id}" name="reservationId" />
				<input type="submit" name="CheckIn" />
		</form>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>