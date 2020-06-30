package com.rohit.flightreservation.services;

import com.rohit.flightreservation.dto.ReservationRequest;
import com.rohit.flightreservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);

}
