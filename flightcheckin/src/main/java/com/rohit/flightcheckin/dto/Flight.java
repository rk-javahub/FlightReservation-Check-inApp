package com.rohit.flightcheckin.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Flight {

	private Long id;
	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private LocalDate dateOfDeparture;
	private Timestamp estimatedDepartureTime;

}
