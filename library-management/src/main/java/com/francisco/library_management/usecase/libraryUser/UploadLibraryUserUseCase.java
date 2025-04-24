package com.francisco.library_management.usecase.libraryUser;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.libraryUser.UploadLibraryUserImpl;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.infraestructure.recive.LibraryUserRecive;

public class UploadLibraryUserUseCase {

	private UploadLibraryUserImpl updateLibraryUserImpl;
	
	public UploadLibraryUserUseCase(UploadLibraryUserImpl uploadLibraryUserImpl) {
		this.updateLibraryUserImpl = uploadLibraryUserImpl;
	}
	
	public ResponseEntity<LibraryUserDto> updateLibraryUser(LibraryUserRecive libraryUserRecive) {
		LibraryUser libraryUser = LibraryUserMapper.libraryUserRecivetoLibraryUser(libraryUserRecive);
		updateLibraryUserImpl.uploadLibraryUser(libraryUser);
		LibraryUserDto libraryUserDto = LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUser);
		return ResponseEntity.ok(libraryUserDto);
	}
	
}
