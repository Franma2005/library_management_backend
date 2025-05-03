package com.francisco.library_management.auth.infraestructure.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

	@GetMapping(value = "/")
	public ResponseEntity<String> hola() {
		return ResponseEntity.ok("hola");
	}
}
