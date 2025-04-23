package com.francisco.library_management.application.services.libraryUser;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.libraryUser.UploadLibraryUserRepository;
import com.francisco.library_management.application.ports.notification.NotificationLibraryUserPort;
import com.francisco.library_management.application.services.servicesInterfaces.libraryUser.UploadLibraryUser;
import com.francisco.library_management.domain.models.LibraryUser;

@Service
public class UploadLibraryUserImpl implements UploadLibraryUser {

	private UploadLibraryUserRepository uploadLibraryUserRepository;
	private NotificationLibraryUserPort notificationRepository;
	
	public UploadLibraryUserImpl(UploadLibraryUserRepository uploadLibraryUserRepository, NotificationLibraryUserPort notificationRepository) {
		this.uploadLibraryUserRepository = uploadLibraryUserRepository;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void uploadLibraryUser(LibraryUser libraryUser) {
		uploadLibraryUserRepository.uploadLibraryUser(libraryUser);
		notificationRepository.notifyLibraryUserChanges();
	}
	
}
