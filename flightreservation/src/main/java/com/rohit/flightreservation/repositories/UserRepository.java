package com.rohit.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String username);

}
