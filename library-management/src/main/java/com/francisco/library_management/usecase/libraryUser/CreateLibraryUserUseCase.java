package com.francisco.library_management.usecase.libraryUser;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.libraryUser.CreateLibraryUserImpl;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.infraestructure.recive.LibraryUserRecive;

public class CreateLibraryUserUseCase {

	private CreateLibraryUserImpl createLibraryUserImpl;
	
	public CreateLibraryUserUseCase(CreateLibraryUserImpl createLibraryUserImpl) {
		this.createLibraryUserImpl = createLibraryUserImpl;
	}
	
	public ResponseEntity<LibraryUserDto> createLibraryUser(LibraryUserRecive libraryUserRecive) {
		LibraryUser libraryUser = LibraryUserMapper.libraryUserRecivetoLibraryUser(libraryUserRecive);
		createLibraryUserImpl.createLibraryUser(libraryUser);
		LibraryUserDto libraryUserDto = LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUser);
		return ResponseEntity.ok(libraryUserDto);
	}
	
}
