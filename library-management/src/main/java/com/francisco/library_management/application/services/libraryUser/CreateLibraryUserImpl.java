package com.francisco.library_management.application.services.libraryUser;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.libraryUser.CreateLibraryUserRepository;
import com.francisco.library_management.application.ports.notification.NotificationLibraryUserPort;
import com.francisco.library_management.application.services.servicesInterfaces.libraryUser.CreateLibraryUser;
import com.francisco.library_management.domain.models.LibraryUser;

@Service
public class CreateLibraryUserImpl implements CreateLibraryUser {

	private CreateLibraryUserRepository createLibraryUserRepository;
	private NotificationLibraryUserPort notificationRepository;
	
	public CreateLibraryUserImpl(CreateLibraryUserRepository createLibraryUserRepository, NotificationLibraryUserPort notificationRepository) {
		this.createLibraryUserRepository = createLibraryUserRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void createLibraryUser(LibraryUser libraryUser) {
		createLibraryUserRepository.createLibraryUser(libraryUser);
		notificationRepository.notifyLibraryUserChanges();
	}
	
}
