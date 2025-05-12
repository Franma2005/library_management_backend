package com.francisco.library_management.application.services.libraryUser;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.libraryUser.LibraryUserByCriteriaRepository;
import com.francisco.library_management.application.services.servicesInterfaces.libraryUser.LibraryUserByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.domain.models.LibraryUser;

@Service
public class LibraryUserByCriteriaImpl implements LibraryUserByCriteria {

	private LibraryUserByCriteriaRepository libraryUserByCriteriaRepository;
	
	public LibraryUserByCriteriaImpl(LibraryUserByCriteriaRepository libraryUserByCriteriaRepository) {
		this.libraryUserByCriteriaRepository = libraryUserByCriteriaRepository;
	}
	
	@Override
	public List<LibraryUser> getLibraryUserByCriteria(Criteria criteria) {
		return libraryUserByCriteriaRepository.findLibraryUserByCriteria(criteria);
	}

	
}
