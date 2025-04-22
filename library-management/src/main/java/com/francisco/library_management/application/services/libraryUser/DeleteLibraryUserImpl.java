package com.francisco.library_management.application.services.libraryUser;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.libraryUser.DeleteLibraryUserRepository;
import com.francisco.library_management.application.services.servicesInterfaces.libraryUser.DeleteLibraryUser;

@Service
public class DeleteLibraryUserImpl implements DeleteLibraryUser {

	private DeleteLibraryUserRepository deleteLibraryUserRepository;
	
	public DeleteLibraryUserImpl(DeleteLibraryUserRepository deleteLibraryUserRepository) {
		this.deleteLibraryUserRepository = deleteLibraryUserRepository;
	}

	@Override
	public void deleteLibraryUser(long id) {
		deleteLibraryUserRepository.deleteLibraryUser(id);
	}
}
