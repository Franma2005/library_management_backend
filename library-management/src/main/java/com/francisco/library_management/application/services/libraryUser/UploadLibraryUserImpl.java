package com.francisco.library_management.application.services.libraryUser;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.libraryUser.UploadLibraryUserRepository;
import com.francisco.library_management.application.services.servicesInterfaces.libraryUser.UploadLibraryUser;
import com.francisco.library_management.domain.models.LibraryUser;

@Service
public class UploadLibraryUserImpl implements UploadLibraryUser {

	private UploadLibraryUserRepository uploadLibraryUserRepository;
	
	public UploadLibraryUserImpl(UploadLibraryUserRepository uploadLibraryUserRepository) {
		this.uploadLibraryUserRepository = uploadLibraryUserRepository;
	}

	@Override
	public void uploadLibraryUser(LibraryUser libraryUser) {
		uploadLibraryUserRepository.uploadLibraryUser(libraryUser);		
	}
	
}
