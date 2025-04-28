package com.francisco.library_management.infraestructure.out.database;

import java.util.List;

import com.francisco.library_management.application.ports.libraryUser.LibraryUserRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.models.LibraryUser;

public class LibraryUserRepositoryImpl implements LibraryUserRepository {

	@Override
	public List<LibraryUser> getAllLibraryUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibraryUser> findLibraryUserByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createLibraryUser(LibraryUser libraryUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLibraryUser(LibraryUser libraryUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLibraryUser(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
