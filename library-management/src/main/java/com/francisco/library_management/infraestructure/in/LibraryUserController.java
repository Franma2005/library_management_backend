package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.usecase.libraryUser.AllLibraryUserUseCase;

@RestController
@RequestMapping("/libraryUser")
public class LibraryUserController {

	private AllLibraryUserUseCase allLibraryUserUseCase;
	
	public LibraryUserController(AllLibraryUserUseCase allLibraryUserUseCase) {
		this.allLibraryUserUseCase = allLibraryUserUseCase;
	}
	
	public ResponseEntity<List<LibraryUserDto>> getAllLibraryUser(
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String surname
	) {
		return allLibraryUserUseCase.findLibraryUser(
				id,
				name,
				surname
		);
	}
	
	public ResponseEntity<LibraryUserDto> createLibraryUser() {
		return null;
	}
	
	public ResponseEntity<LibraryUserDto> updateLibraryUser() {
		return null;
	}
	
	public ResponseEntity<LibraryUserDto> deleteLibraryUser() {
		return null;
	}
	
}
