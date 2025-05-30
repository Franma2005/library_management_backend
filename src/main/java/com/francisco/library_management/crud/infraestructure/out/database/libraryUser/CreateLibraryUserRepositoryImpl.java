package com.francisco.library_management.crud.infraestructure.out.database.libraryUser;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.libraryUser.CreateLibraryUserRepository;
import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;

@Repository
public class CreateLibraryUserRepositoryImpl implements CreateLibraryUserRepository {

	private LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	
	public CreateLibraryUserRepositoryImpl(LibraryUserRepositoryDatabase libraryUserRepositoryDatabase) {
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
	}

	@Override
	public boolean createLibraryUser(LibraryUser libraryUser) {
		LibraryUserEntity libraryUserEntity = mapToLibraryUserEntity(libraryUser);
		libraryUserRepositoryDatabase.save(libraryUserEntity);
		return true;
	}
	
	private LibraryUserEntity mapToLibraryUserEntity(LibraryUser libraryUser) {
		return LibraryUserMapper.libraryUsertoLibraryUserEntity(libraryUser);
	}

}
