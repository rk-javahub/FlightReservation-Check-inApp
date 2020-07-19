package com.rohit.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.rohit.flightreservation.controller.UserController;

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

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Override
	public boolean login(String username, String password) {
		LOGGER.info("Inside SecurityServiceImpl's  login().");
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
