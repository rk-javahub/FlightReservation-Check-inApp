package com.rohit.flightreservation.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Cacheable
public class Flight extends AbstractEntity {

	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private LocalDate dateOfDeparture;
	private Timestamp estimatedDepartureTime;

}
