package com.rohit.flightreservation.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rohit.flightreservation.dto.ReservationRequest;
import com.rohit.flightreservation.entities.Flight;
import com.rohit.flightreservation.entities.Passenger;
import com.rohit.flightreservation.entities.Reservation;
import com.rohit.flightreservation.repositories.FlightRepository;
import com.rohit.flightreservation.repositories.PassengerRepository;
import com.rohit.flightreservation.repositories.ReservationRepository;
import com.rohit.flightreservation.util.EmailUtil;
import com.rohit.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${PDFLocation}")
	private String ITINERARY_DIR;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerrepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	// You can add Payment Process here using any Payment Gateway (Extra
	// Functionality)

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("Inside bookFlight() in ReservationServiceImpl");

		LOGGER.info("Fetching flight for the Flight id: " + request.getFlightId());
		Flight flight = flightRepository.getOne(request.getFlightId());

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving the Passenger");
		Passenger savedPassenger = passengerrepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the Reservation");
		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";

		LOGGER.info("Generating the Itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);

		/**
		 * Code for Email (Not working right now [java.net.UnknownHostException:
		 * smtp.gmail.com])
		 */
		// emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}
}
