package com.francisco.library_management.crud.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteLibraryUserRepository {
	
	public boolean deleteLibraryUser(long id);
	
}
