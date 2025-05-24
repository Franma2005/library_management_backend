package com.francisco.library_management.crud.application.services.libraryUser;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.UpdateLibraryUserRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.UpdateLibraryUser;

@Service
public class UpdateLibraryUserImpl implements UpdateLibraryUser {

	private UpdateLibraryUserRepository updateLibraryUserRepository;
	private NotificationPort notificationPort;
	
	public UpdateLibraryUserImpl(
			UpdateLibraryUserRepository updateLibraryUserRepository,
			NotificationPort notificationPort
	) {
		this.updateLibraryUserRepository = updateLibraryUserRepository;
		this.notificationPort = notificationPort;
	}

	@Override
	public void updateLibraryUser(LibraryUser libraryUser) {
		updateLibraryUserRepository.updateLibraryUser(libraryUser);
		notificationPort.sendNotification(NotificationType.LIBRARYUSERRELOAD);
	}
	
}
