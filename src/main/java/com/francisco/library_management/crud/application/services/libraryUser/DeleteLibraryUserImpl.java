package com.francisco.library_management.crud.application.services.libraryUser;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.DeleteLibraryUserRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.DeleteLibraryUser;

@Service
public class DeleteLibraryUserImpl implements DeleteLibraryUser {

	private DeleteLibraryUserRepository deleteLibraryUserRepository;
	private NotificationLibraryUserPort notificationRepository;
	
	public DeleteLibraryUserImpl(DeleteLibraryUserRepository deleteLibraryUserRepository) {
		this.deleteLibraryUserRepository = deleteLibraryUserRepository;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void deleteLibraryUser(Long id) {
		deleteLibraryUserRepository.deleteLibraryUser(id);
		notificationRepository.notifyLibraryUserChanges();
	}
}
