package com.francisco.library_management.application.ports.libraryUser;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.LibraryUser;

@Repository
public interface AllLibraryUsersRepository {
	List<LibraryUser> getAllLibraryUsers();
}
