package com.francisco.library_management.infraestructure.mapper;

import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.recive.LibraryUserRecive;

public class LibraryUserMapper {
	
	public static LibraryUser libraryUserRecivetoLibraryUser(LibraryUserRecive libraryUserRecive) {
		return LibraryUser.builder()
				.id(libraryUserRecive.getId())
				.name(libraryUserRecive.getName())
				.surname(libraryUserRecive.getSurname())
				.build();
	}
	
	public static LibraryUserDto libraryUsertoLibraryUserDto(LibraryUser libraryUser) {
		return LibraryUserDto.builder()
				.id(libraryUser.getId())
				.name(libraryUser.getName())
				.surname(libraryUser.getSurname())
				.build();
	}
	
}
