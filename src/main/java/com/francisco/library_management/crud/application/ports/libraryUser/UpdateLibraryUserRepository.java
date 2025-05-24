package com.francisco.library_management.crud.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.models.LibraryUser;

@Repository
public interface UpdateLibraryUserRepository {
	
	public boolean updateLibraryUser(LibraryUser libraryUser);
	
}
