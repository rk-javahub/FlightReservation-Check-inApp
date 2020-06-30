package com.rohit.flightcheckin.integration;

import com.rohit.flightcheckin.dto.Reservation;
import com.rohit.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);

}
