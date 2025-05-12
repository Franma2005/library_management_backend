package com.francisco.library_management.infraestructure.out.database.libraryUser;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.libraryUser.UpdateLibraryUserRepository;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;

@Repository
public class UpdateLibraryUserRepositoryImpl implements UpdateLibraryUserRepository {

	private LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	
	public UpdateLibraryUserRepositoryImpl(LibraryUserRepositoryDatabase libraryUserRepositoryDatabase) {
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
	}
	
	@Override
	public boolean updateLibraryUser(LibraryUser libraryUser) {
		LibraryUserEntity libraryUserEntity = mapToLibraryUserEntity(libraryUser);
		libraryUserRepositoryDatabase.save(libraryUserEntity);
		return true;
	}
	
	private LibraryUserEntity mapToLibraryUserEntity(LibraryUser libraryUser) {
		return LibraryUserMapper.libraryUsertoLibraryUserEntity(libraryUser);
	}

}
