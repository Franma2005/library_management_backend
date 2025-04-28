package com.francisco.library_management.usecase.libraryUser;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.libraryUser.UpdateLibraryUserImpl;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.infraestructure.recive.LibraryUserRecive;

@Component
public class UpdateLibraryUserUseCase {

	private UpdateLibraryUserImpl updateLibraryUserImpl;
	
	public UpdateLibraryUserUseCase(UpdateLibraryUserImpl uploadLibraryUserImpl) {
		this.updateLibraryUserImpl = uploadLibraryUserImpl;
	}
	
	public ResponseEntity<LibraryUserDto> updateLibraryUser(LibraryUserRecive libraryUserRecive) {
		LibraryUser libraryUser = LibraryUserMapper.libraryUserRecivetoLibraryUser(libraryUserRecive);
		updateLibraryUserImpl.updateLibraryUser(libraryUser);
		LibraryUserDto libraryUserDto = LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUser);
		return ResponseEntity.ok(libraryUserDto);
	}
	
}
