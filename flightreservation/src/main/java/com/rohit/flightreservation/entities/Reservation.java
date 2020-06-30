package com.rohit.flightreservation.entities;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation extends AbstractEntity {
	private Long id;
	private Boolean checkedIn;
	
	private int numberOfbags;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
}
