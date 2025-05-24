package com.francisco.library_management.crud.application.services.libraryUser;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.UpdateLibraryUserRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.UpdateLibraryUser;

@Service
public class UpdateLibraryUserImpl implements UpdateLibraryUser {

	private UpdateLibraryUserRepository updateLibraryUserRepository;
	private NotificationLibraryUserPort notificationRepository;
	
	public UpdateLibraryUserImpl(UpdateLibraryUserRepository updateLibraryUserRepository) {
		this.updateLibraryUserRepository = updateLibraryUserRepository;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void updateLibraryUser(LibraryUser libraryUser) {
		updateLibraryUserRepository.updateLibraryUser(libraryUser);
		notificationRepository.notifyLibraryUserChanges();
	}
	
}
