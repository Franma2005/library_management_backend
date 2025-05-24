package com.francisco.library_management.crud.application.ports.libraryUser;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.models.LibraryUser;

@Repository
public interface AllLibraryUsersRepository {
	
	public List<LibraryUser> getAllLibraryUsers();
	
}
