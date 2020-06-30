package com.rohit.flightreservation.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passenger extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String phone;

}
