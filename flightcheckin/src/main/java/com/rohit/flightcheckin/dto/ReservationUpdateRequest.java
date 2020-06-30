package com.rohit.flightcheckin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationUpdateRequest {
	private Long id;
	private Boolean checkedIn;
	private int numberOfbags;
}
