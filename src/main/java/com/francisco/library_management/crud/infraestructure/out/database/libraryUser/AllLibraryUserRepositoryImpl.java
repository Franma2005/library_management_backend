package com.francisco.library_management.crud.infraestructure.out.database.libraryUser;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.libraryUser.AllLibraryUsersRepository;
import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.mapper.LibraryUserGroupMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;

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
