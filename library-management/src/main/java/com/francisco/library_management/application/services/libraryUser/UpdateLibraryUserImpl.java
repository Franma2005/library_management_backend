package com.francisco.library_management.application.services.libraryUser;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.libraryUser.UpdateLibraryUserRepository;
import com.francisco.library_management.application.ports.notification.NotificationLibraryUserPort;
import com.francisco.library_management.application.services.servicesInterfaces.libraryUser.UpdateLibraryUser;
import com.francisco.library_management.domain.models.LibraryUser;

@Service
public class UpdateLibraryUserImpl implements UpdateLibraryUser {

	private UpdateLibraryUserRepository updateLibraryUserRepository;
	private NotificationLibraryUserPort notificationRepository;
	
	public UpdateLibraryUserImpl(UpdateLibraryUserRepository updateLibraryUserRepository,
			NotificationLibraryUserPort notificationRepository) {
		this.updateLibraryUserRepository = updateLibraryUserRepository;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void updateLibraryUser(LibraryUser libraryUser) {
		updateLibraryUserRepository.updateLibraryUser(libraryUser);
		notificationRepository.notifyLibraryUserChanges();
	}
	
}
