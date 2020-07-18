package com.rohit.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rohit.flightcheckin.dto.Reservation;
import com.rohit.flightcheckin.dto.ReservationUpdateRequest;
import com.rohit.flightcheckin.integration.ReservationRestClient;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient reservationRestClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = reservationRestClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}

	@RequestMapping("/completeCheckIn")
	public String completeCheckin(@RequestParam("reservationId") long reservationId,
			@RequestParam("numberOfbags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfbags(numberOfBags);
		reservationRestClient.updateReservation(reservationUpdateRequest);
		return "chekinConfirmation";
	}

}
