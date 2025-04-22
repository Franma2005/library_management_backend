package com.francisco.library_management.infraestructure.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.domain.models.LibraryUser;

@RestController
@RequestMapping("/libraryUser")
public class LibraryUserController {

	public ResponseEntity<LibraryUser> getAllLibraryUser(
			@RequestParam(required = false) long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String surname
	) {
		return null;
	}
	
	public ResponseEntity<LibraryUser> createLibraryUser() {
		return null;
	}
	
	public ResponseEntity<LibraryUser> updateLibraryUser() {
		return null;
	}
	
	public ResponseEntity<LibraryUser> deleteLibraryUser() {
		return null;
	}
	
}
