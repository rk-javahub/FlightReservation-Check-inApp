package com.rohit.flightreservation.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role extends AbstractEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	@Override
	public String getAuthority() {
		return name;
	}
}
