package com.rohit.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rohit.flightreservation.entities.User;
import com.rohit.flightreservation.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/showReg")
	public String showRegister() {
		LOGGER.info("Inside showRegister()");
		return "login/registerUser";
	}

	@RequestMapping("/registerUser")
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register()" + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("Inside login() and email is" + username);
		User user = userRepository.findByEmail(username);
		if (user.getPassword().equals(password)) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid Username or Password. Please try again");
		}
		return "login/login";
	}

	@RequestMapping("/loginpage")
	public String loginPage() {
		LOGGER.info("Inside loginpage()");
		return "login/login";
	}
}
