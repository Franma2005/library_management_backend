package com.francisco.library_management.crud.usecase.libraryUser;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.libraryUser.CreateLibraryUserImpl;
import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.crud.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.crud.infraestructure.recive.LibraryUserRecive;

@Component
public class CreateLibraryUserUseCase {

	private CreateLibraryUserImpl createLibraryUserImpl;
	
	public CreateLibraryUserUseCase(CreateLibraryUserImpl createLibraryUserImpl) {
		this.createLibraryUserImpl = createLibraryUserImpl;
	}
	
	public LibraryUserDto createLibraryUser(LibraryUserRecive libraryUserRecive) {
		LibraryUser libraryUser = LibraryUserMapper.libraryUserRecivetoLibraryUser(libraryUserRecive);
		createLibraryUserImpl.createLibraryUser(libraryUser);
		LibraryUserDto libraryUserDto = LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUser);
		return libraryUserDto;
	}
	
}
