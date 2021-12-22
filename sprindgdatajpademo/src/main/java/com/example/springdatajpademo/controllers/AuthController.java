package com.example.springdatajpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpademo.request.LoginRequest;
import com.example.springdatajpademo.response.LoginResponse;
import com.example.springdatajpademo.services.JWTUtilService;
import com.example.springdatajpademo.services.MyUserDetailsService;

@RestController
@RequestMapping("/api")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private JWTUtilService jwtUtilService;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest logReq) throws Exception {
		try {
			
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(logReq.getUsername(), logReq.getPassword()));
		}catch(Exception e) {
			throw new Exception("Incorrect login credentials");
		}
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(logReq.getUsername());
		String jwt = jwtUtilService.generateToken(userDetails);
		return new LoginResponse("Login Successful",jwt);
	}
}
