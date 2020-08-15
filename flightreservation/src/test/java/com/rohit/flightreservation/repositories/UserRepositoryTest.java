package com.rohit.flightreservation.repositories;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rohit.flightreservation.FlightreservationApplication;
import com.rohit.flightreservation.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightreservationApplication.class)
public class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;

	@Test
	public void testFindByEmail() {
		User expected = new User();
		expected.setFirstName("Rohit");
		expected.setId(1L);
		expected.setEmail("kumbharrohit13@gmail.com");
		expected.setLastName("Kumbhar");
		expected.setPassword("abcd");

		// fail("Not yet implemented");
		assertEquals(expected, userRepository.findByEmail("kumbharrohit13@gmail.com"));
	}
}
