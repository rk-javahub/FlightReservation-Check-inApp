package com.rohit.flightcheckin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Passenger {

	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String phone;

}
