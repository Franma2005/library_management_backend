package com.francisco.library_management.application.services.libraryUser;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.libraryUser.AllLibraryUsersRepository;
import com.francisco.library_management.application.services.servicesInterfaces.libraryUser.AllLibraryUsers;
import com.francisco.library_management.domain.models.LibraryUser;

@Service
public class AllLibraryUsersImpl implements AllLibraryUsers {

	private AllLibraryUsersRepository allLibraryUserRepository;
	
	public AllLibraryUsersImpl(AllLibraryUsersRepository allLibraryUsersRepository) {
		this.allLibraryUserRepository = allLibraryUsersRepository;
	}
	
	@Override
	public List<LibraryUser> getAllLibraryUsers() {
		return allLibraryUserRepository.getAllLibraryUsers();
	}

}
