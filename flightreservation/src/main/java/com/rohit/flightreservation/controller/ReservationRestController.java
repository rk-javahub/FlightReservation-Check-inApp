package com.rohit.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rohit.flightreservation.dto.ReservationUpdateRequest;
import com.rohit.flightreservation.entities.Reservation;
import com.rohit.flightreservation.repositories.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;

	Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation for an id" + id);
		return reservationRepository.findById(id).get();
	}

	@RequestMapping("/reservations")
	public Reservation updatedReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updateReservation for an request" + request);
		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setNumberOfbags(request.getNumberOfbags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);
	}
}
