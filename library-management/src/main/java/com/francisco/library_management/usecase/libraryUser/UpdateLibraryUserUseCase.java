package com.francisco.library_management.usecase.libraryUser;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.libraryUser.UploadLibraryUserImpl;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.infraestructure.recive.LibraryUserRecive;

@Component
public class UpdateLibraryUserUseCase {

	private UploadLibraryUserImpl updateLibraryUserImpl;
	
	public UpdateLibraryUserUseCase(UploadLibraryUserImpl uploadLibraryUserImpl) {
		this.updateLibraryUserImpl = uploadLibraryUserImpl;
	}
	
	public ResponseEntity<LibraryUserDto> updateLibraryUser(LibraryUserRecive libraryUserRecive) {
		LibraryUser libraryUser = LibraryUserMapper.libraryUserRecivetoLibraryUser(libraryUserRecive);
		updateLibraryUserImpl.uploadLibraryUser(libraryUser);
		LibraryUserDto libraryUserDto = LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUser);
		return ResponseEntity.ok(libraryUserDto);
	}
	
}
