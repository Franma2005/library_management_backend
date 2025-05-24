package com.francisco.library_management.crud.application.services.libraryUser;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.CreateLibraryUserRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.CreateLibraryUser;

@Service
public class CreateLibraryUserImpl implements CreateLibraryUser {

	private CreateLibraryUserRepository createLibraryUserRepository;
	private NotificationPort notificationPort;
	
	public CreateLibraryUserImpl(
			CreateLibraryUserRepository createLibraryUserRepository,
			NotificationPort notificationPort
	) {
		this.createLibraryUserRepository = createLibraryUserRepository;
		this.notificationPort = notificationPort;
	}
	
	@Override
	public void createLibraryUser(LibraryUser libraryUser) {
		createLibraryUserRepository.createLibraryUser(libraryUser);
		notificationPort.sendNotification(NotificationType.LIBRARYUSERRELOAD);
	}
	
}
