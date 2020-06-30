<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<h2>Complete Reservation</h2>
<div>
	Airline: ${flight.operatingAirlines} <br /> 
	Departure City: ${flight.departureCity} <br /> 
	Arrival City: ${flight.arrivalCity} <br />
</div>
<body>
	<form action="completeReservation" method="post">

		<h2>Passenger Details</h2>
		First name:<input type="text" name="passengerFirstName" /><br />
		Last name:<input type="text" name="passengerLastName" /><br />
		Email:<input type="text" name="passengerEmail" /><br /> 
		Phone:<input type="text" name="passengerPhone" /><br />

		<h2>Card Details</h2>
		Name on the card:<input type="text" name="nameOnTheCard" /><br />
		Card No:<input type="text" name="cardNo" /> <br />
	    Expiry Date:<input type="text" name="expiryDate" /><br /> 
	    Three Digit Sec Code :<input type="text" name="securityCode" /><br /> 
	    <input type="hidden"value="${flight.id}" name="flightId"/> <br /> 
	    <input type="submit" value="CONFIRM" style="font: bolder; background: fuchsia;" />

	</form>
</body>
</html>