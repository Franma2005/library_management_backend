package com.francisco.library_management.crud.usecase.libraryUser;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.libraryUser.UpdateLibraryUserImpl;
import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.crud.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.crud.infraestructure.recive.LibraryUserRecive;

@Component
public class UpdateLibraryUserUseCase {

	private UpdateLibraryUserImpl updateLibraryUserImpl;
	
	public UpdateLibraryUserUseCase(UpdateLibraryUserImpl uploadLibraryUserImpl) {
		this.updateLibraryUserImpl = uploadLibraryUserImpl;
	}
	
	public LibraryUserDto updateLibraryUser(LibraryUserRecive libraryUserRecive) {
		LibraryUser libraryUser = LibraryUserMapper.libraryUserRecivetoLibraryUser(libraryUserRecive);
		updateLibraryUserImpl.updateLibraryUser(libraryUser);
		LibraryUserDto libraryUserDto = LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUser);
		return libraryUserDto;
	}
	
}
