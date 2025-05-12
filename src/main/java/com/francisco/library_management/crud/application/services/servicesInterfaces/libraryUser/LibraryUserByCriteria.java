package com.francisco.library_management.application.services.servicesInterfaces.libraryUser;

import java.util.List;

import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.domain.models.LibraryUser;

public interface LibraryUserByCriteria {

	public List<LibraryUser> getLibraryUserByCriteria(Criteria criteria);
	
}
