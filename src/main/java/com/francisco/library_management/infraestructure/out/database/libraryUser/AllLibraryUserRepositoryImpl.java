package com.francisco.library_management.infraestructure.out.database.libraryUser;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.libraryUser.AllLibraryUsersRepository;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.mapper.LibraryUserGroupMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;

@Repository
public class AllLibraryUserRepositoryImpl implements AllLibraryUsersRepository{

	private LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	
	public AllLibraryUserRepositoryImpl(LibraryUserRepositoryDatabase libraryUserRepositoryDatabase) {
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
	}

	@Override
	public List<LibraryUser> getAllLibraryUsers() {
		List<LibraryUserEntity> libraryUserEntityGroup = libraryUserRepositoryDatabase.findAll();
		List<LibraryUser> libraryUserGroup = mapToLibraryUser(libraryUserEntityGroup);
		return libraryUserGroup;
	}
	
	private List<LibraryUser> mapToLibraryUser(List<LibraryUserEntity> libraryUserEntityGroup) {
		return LibraryUserGroupMapper.libraryUserEntityGrouptoLibraryUserGroup(libraryUserEntityGroup);
	}
	
}
