package com.rohit.flightreservation.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rohit.flightreservation.services.SecurityServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	private static final String[] PUBLIC_MATCHERS = { "/webjars/**", "/css/**", "/js/**", "/image/**", "/", "/showReg",
			"/index.html", "/registerUser", "/fonts/**", "/loginpage", "/showLogin", "/login/*", "/login" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOGGER.info("Inside configure() of WebSecurityConfig class.");
		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().antMatchers("/admin/showAddFlight")
				.hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();

	}
}
