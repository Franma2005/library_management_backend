package com.francisco.library_management.crud.application.services.libraryUser;

import java.util.List;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.libraryUser.LibraryUserByCriteriaRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.libraryUser.LibraryUserByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;

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
