package com.francisco.library_management.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.LibraryUser;

@Repository
public interface UpdateLibraryUserRepository {
	boolean updateLibraryUser(LibraryUser libraryUser);
}
