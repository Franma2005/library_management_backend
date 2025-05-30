package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.recive.LibraryUserRecive;
import com.francisco.library_management.usecase.libraryUser.AllLibraryUserUseCase;
import com.francisco.library_management.usecase.libraryUser.CreateLibraryUserUseCase;
import com.francisco.library_management.usecase.libraryUser.DeleteLibraryUserUseCase;
import com.francisco.library_management.usecase.libraryUser.UpdateLibraryUserUseCase;

@RestController
@RequestMapping("/libraryUser")
public class LibraryUserController {

	private AllLibraryUserUseCase allLibraryUserUseCase;
	private CreateLibraryUserUseCase createLibraryUserUseCase;
	private UpdateLibraryUserUseCase updateLibraryUserUseCase;
	private DeleteLibraryUserUseCase deleteLibraryUserUseCase;
	
	public LibraryUserController(AllLibraryUserUseCase allLibraryUserUseCase, CreateLibraryUserUseCase createLibraryUserUseCase, UpdateLibraryUserUseCase updateLibraryUserUseCase, DeleteLibraryUserUseCase deleteLibraryUserUseCase) {
		this.allLibraryUserUseCase = allLibraryUserUseCase;
		this.createLibraryUserUseCase = createLibraryUserUseCase;
		this.updateLibraryUserUseCase = updateLibraryUserUseCase;
		this.deleteLibraryUserUseCase = deleteLibraryUserUseCase;
	}
	
	@GetMapping("/")
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
	
	@PostMapping("/")
	public ResponseEntity<LibraryUserDto> createLibraryUser(
			@RequestBody LibraryUserRecive libraryUserRecive
	) {
		return createLibraryUserUseCase.createLibraryUser(libraryUserRecive);
	}
	
	@PutMapping("/")
	public ResponseEntity<LibraryUserDto> updateLibraryUser(
			@RequestBody LibraryUserRecive libraryUserRecive		
	) {
		return updateLibraryUserUseCase.updateLibraryUser(libraryUserRecive);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<LibraryUserDto> deleteLibraryUser(
			@RequestParam Long id
	) {
		return deleteLibraryUserUseCase.deleteLibraryUser(id);
	}
	
}
