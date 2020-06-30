package com.rohit.flightcheckin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Reservation {

	private Long id;
	private Boolean checkedIn;
	private int numberOfbags;
	private Passenger passenger;
	private Flight flight;
}
