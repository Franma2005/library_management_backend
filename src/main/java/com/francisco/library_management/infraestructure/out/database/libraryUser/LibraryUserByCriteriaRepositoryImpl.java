package com.francisco.library_management.infraestructure.out.database.libraryUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.libraryUser.LibraryUserByCriteriaRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.Filter;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.filters.command.registry.LibraryUserFilterCommandRegistry;
import com.francisco.library_management.infraestructure.filters.interfaces.MyLibraryUserCommand;
import com.francisco.library_management.infraestructure.mapper.LibraryUserGroupMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;

@Repository
public class LibraryUserByCriteriaRepositoryImpl implements LibraryUserByCriteriaRepository {

	private LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	private LibraryUserFilterCommandRegistry libraryUserFilterCommandRegistry;
	
	public LibraryUserByCriteriaRepositoryImpl(LibraryUserRepositoryDatabase libraryUserRepositoryDatabase,
			LibraryUserFilterCommandRegistry libraryUserFilterCommandRegistry) {
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
		this.libraryUserFilterCommandRegistry = libraryUserFilterCommandRegistry;
	}

	@Override
	public List<LibraryUser> findLibraryUserByCriteria(Criteria criteria) {
		List<LibraryUserEntity> libraryUserEntityGroup = libraryUserRepositoryDatabase.findAll();
		List<LibraryUser> libraryUserGroup = mapToLibraryUserGroup(libraryUserEntityGroup);
		
		if(!criteria.getFilter().isEmpty())
			libraryUserGroup = filter(libraryUserGroup, criteria);
		
		return null;
	}
	
	private List<LibraryUser> mapToLibraryUserGroup(List<LibraryUserEntity> libraryUserEntityGroup) {
		return LibraryUserGroupMapper.libraryUserEntityGrouptoLibraryUserGroup(libraryUserEntityGroup);
	}
	
	private List<LibraryUser> filter(List<LibraryUser> libraryUserGroup, Criteria criteria) {
		List<LibraryUser> libraryUserGroupFilter = new ArrayList<LibraryUser>();
		for (LibraryUser libraryUser : libraryUserGroup) {
			if(matchesCriteria(libraryUser, criteria.getFilter()))
				libraryUserGroup.add(libraryUser);
		}
		
		return libraryUserGroupFilter;
	}
	
	private boolean matchesCriteria(LibraryUser libraryUser, List<Filter<?>> filters) {
		boolean allFiltersComplete = true;
		
		for (Filter<?> filter : filters) {
			if(!matchesFilter(libraryUser, filter))
				allFiltersComplete = false;
		}
		
		return allFiltersComplete;
	}
	
	private boolean matchesFilter(LibraryUser libraryUser, Filter<?> filter) {
		String field = filter.getField();
		Object value = filter.getValue();
		
		MyLibraryUserCommand myLibraryUserCommand = libraryUserFilterCommandRegistry.getCommand(field);
		return myLibraryUserCommand.execute(libraryUser, value);
	}
	
}
