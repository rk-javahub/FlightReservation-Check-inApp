package com.rohit.flightreservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationRequest {
	private Long flightId;
	private String passengerFirstName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerPhone;
	private String nameOnTheCard;
	private String cardNo;
	private String expiryDate;
	private String securityCode;

}
