package com.rohit.flightreservation.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rohit.flightreservation.entities.Flight;
import com.rohit.flightreservation.repositories.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	FlightRepository flightRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping("findFlights")
	public String finFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(iso = ISO.DATE) LocalDate departureDate, ModelMap modelMap) {
		LOGGER.info("Inside findFlights() " + from + "To:" + to + "departureDate");
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		System.out.println("FlightRepository executed");
		modelMap.addAttribute("Flights", flights);
		LOGGER.info("Flights found are" + flights);
		return "displayFlights";
	}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
}
