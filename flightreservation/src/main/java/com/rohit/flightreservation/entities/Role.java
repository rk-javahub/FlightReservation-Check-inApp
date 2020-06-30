package com.rohit.flightreservation.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role extends AbstractEntity {
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
}
