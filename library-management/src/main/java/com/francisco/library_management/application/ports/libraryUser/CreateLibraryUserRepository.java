package com.francisco.library_management.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.LibraryUser;

@Repository
public interface CreateLibraryUserRepository {
	void createLibraryUser(LibraryUser libraryUser);
}
