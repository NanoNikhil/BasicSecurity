package com.basicSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

	

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to java Techie online first batch !";
	}

	@GetMapping("/text")
	public String greeting() {
		return "Happy to See you Here !";
	}
	

	@GetMapping("/nonsecureapp")
	public String home() {
		return "This MEthod you can no need of security every one can access! ";
	}
	
	
}
