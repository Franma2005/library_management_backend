package com.francisco.library_management.crud.application.services.libraryUser;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.CreateLibraryUserRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.CreateLibraryUser;

@Service
public class CreateLibraryUserImpl implements CreateLibraryUser {

	private CreateLibraryUserRepository createLibraryUserRepository;
	private NotificationLibraryUserPort notificationRepository;
	
	public CreateLibraryUserImpl(CreateLibraryUserRepository createLibraryUserRepository) {
		this.createLibraryUserRepository = createLibraryUserRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void createLibraryUser(LibraryUser libraryUser) {
		createLibraryUserRepository.createLibraryUser(libraryUser);
		notificationRepository.notifyLibraryUserChanges();
	}
	
}
