package com.rohit.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rohit.flightreservation.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
