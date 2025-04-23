package com.francisco.library_management.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteLibraryUserRepository {
	boolean deleteLibraryUser(long id);
}
