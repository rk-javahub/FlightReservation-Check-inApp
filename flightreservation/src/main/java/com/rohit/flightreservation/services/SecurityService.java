package com.rohit.flightreservation.services;

/**
 * Interface for Authenticating and Authorizing user.
 * 
 * @author Rohit
 *
 */
public interface SecurityService {
	public boolean login(String username, String password);
}
