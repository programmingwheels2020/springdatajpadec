package com.example.springsecuritydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/home")
	public String home() {
		return "<h1>This is home</h1>";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "<h1>This is welcome</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>This is admin</h1>";
	}

}
