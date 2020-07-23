package com.rohit.flightreservation.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rohit.flightreservation.entities.User;
import com.rohit.flightreservation.repositories.UserRepository;
import com.rohit.flightreservation.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private SecurityService securityService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * Method to trim leading and trailing whitespace to prevent validation error.
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showReg")
	public String showRegister(Model model) {
		LOGGER.info("Inside showRegister()");
		model.addAttribute("user", new User());
		return "login/registerUser";
	}

	@RequestMapping("/registerUser")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		LOGGER.info("Inside register()" + user);
		if (bindingResult.hasErrors()) {
			LOGGER.info("Entered in to bindingResult if statement...");
			return "login/registerUser";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("Inside login() and email is" + username);
		boolean loginStatus = securityService.login(username, password);
		if (loginStatus) {
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
