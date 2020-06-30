package com.rohit.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.flightreservation.entities.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
