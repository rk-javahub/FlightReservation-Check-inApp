package com.rohit.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rohit.flightreservation.dto.ReservationRequest;
import com.rohit.flightreservation.entities.Flight;
import com.rohit.flightreservation.entities.Reservation;
import com.rohit.flightreservation.repositories.FlightRepository;
import com.rohit.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ReservationService reservationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap) {
		LOGGER.info("showCompleteReservation() invoked with Flight id " + flightId);
		Flight flight = flightRepository.getOne(flightId);
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is " + flight);
		return "completeReservation";
	}

	@RequestMapping(value = "completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("completeReservation() " + request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and Id is : " + reservation.getId());
		return "reservationConfirmation";
	}
}
