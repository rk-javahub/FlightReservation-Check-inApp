package com.rohit.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * SecurityServiceImpl responsible to perform user authentication.
 * 
 * @author Rohit
 *
 */

@Service
public class SecurityServiceImpl implements SecurityService {

	/**
	 * Interface which loads user specific data.
	 */
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public boolean login(String username, String password) {
		// Locate user based on Username.
		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(username);

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password,
				loadUserByUsername.getAuthorities());

		authenticationManager.authenticate(token);

		boolean result = token.isAuthenticated();

		if (result) {
			// Associates a given SecurityContext with the current execution thread.
			SecurityContextHolder.getContext().setAuthentication(token);

		}

		return result;
	}
}
