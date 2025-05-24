package com.francisco.library_management.crud.application.services.libraryUser;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.DeleteLibraryUserRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.DeleteLibraryUser;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

@Service
public class DeleteLibraryUserImpl implements DeleteLibraryUser {

	private DeleteLibraryUserRepository deleteLibraryUserRepository;
	private NotificationPort notificationPort;
	
	public DeleteLibraryUserImpl(
			DeleteLibraryUserRepository deleteLibraryUserRepository,
			NotificationPort notificationPort
	) {
		this.deleteLibraryUserRepository = deleteLibraryUserRepository;
		this.notificationPort = notificationPort;
	}

	@Override
	public void deleteLibraryUser(Long id) {
		deleteLibraryUserRepository.deleteLibraryUser(id);
		notificationPort.sendNotification(NotificationType.LIBRARYUSERRELOAD);
	}
}
