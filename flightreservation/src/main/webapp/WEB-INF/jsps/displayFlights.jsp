<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td {
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<h2>Flights</h2>
<body>
	<table border="1">
		<tr>
			<th>Airline</th>
			<th>Departure City</th>
			<th>Arrival City</th>
			<th>Departure Time</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${Flights}" var="flight">
			<tr>
				<td>${flight.operatingAirlines}</td>
				<td>${flight.departureCity}</td>
				<td>${flight.arrivalCity}</td>
				<td>${flight.estimatedDepartureTime}</td>
				<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
			</tr>
		</c:forEach>
		<tr></tr>

	</table>
</body>
</html>