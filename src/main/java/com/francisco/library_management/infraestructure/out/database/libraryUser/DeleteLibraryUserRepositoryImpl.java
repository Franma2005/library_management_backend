package com.francisco.library_management.infraestructure.out.database.libraryUser;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.libraryUser.DeleteLibraryUserRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.mapper.LibraryUserMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;

@Repository
public class DeleteLibraryUserRepositoryImpl implements DeleteLibraryUserRepository {

	private LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	private LibraryUserByCriteriaRepositoryImpl libraryUserByCriteriaRepositoryImpl;
	
	public DeleteLibraryUserRepositoryImpl(LibraryUserRepositoryDatabase libraryUserRepositoryDatabase,
			LibraryUserByCriteriaRepositoryImpl libraryUserByCriteriaRepositoryImpl) {
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
		this.libraryUserByCriteriaRepositoryImpl = libraryUserByCriteriaRepositoryImpl;
	}

	@Override
	public boolean deleteLibraryUser(long id) {
		LibraryUser libraryUser = getLibraryUserForDelete(id);
		LibraryUserEntity libraryUserEntity = mapToLibraryUserEntity(libraryUser);
		libraryUserRepositoryDatabase.delete(libraryUserEntity);
		return true;
	}
	
	private LibraryUserEntity mapToLibraryUserEntity(LibraryUser libraryUser) {
		return LibraryUserMapper.libraryUsertoLibraryUserEntity(libraryUser);
	}
	
	private LibraryUser getLibraryUserForDelete(long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.of(id))
				.build();
		List<LibraryUser> libraryUser =
				libraryUserByCriteriaRepositoryImpl.findLibraryUserByCriteria(criteria);
		return libraryUser.get(0);
	}
	
}
