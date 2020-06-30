package com.rohit.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
