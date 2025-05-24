package com.francisco.library_management.crud.application.services.libraryUser;

import java.util.List;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.AllLibraryUsersRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.AllLibraryUsers;

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
