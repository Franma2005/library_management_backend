package com.francisco.library_management.crud.usecase.libraryUser;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.libraryUser.AllLibraryUsersImpl;
import com.francisco.library_management.crud.application.services.libraryUser.LibraryUserByCriteriaImpl;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.crud.infraestructure.mapper.LibraryUserGroupMapper;

@Component
public class AllLibraryUserUseCase {

	private AllLibraryUsersImpl allLibraryUserImpl;
	private LibraryUserByCriteriaImpl libraryUserByCriteriaImpl;
	
	public AllLibraryUserUseCase(AllLibraryUsersImpl allLibraryUserImpl,
			LibraryUserByCriteriaImpl libraryUserByCriteriaImpl) {
		this.allLibraryUserImpl = allLibraryUserImpl;
		this.libraryUserByCriteriaImpl = libraryUserByCriteriaImpl;
	}
	
	public List<LibraryUserDto> findLibraryUser(
			Long id,
			String name,
			String surname
	) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.addFilterIfPresent("name", Optional.ofNullable(name))
				.addFilterIfPresent("surname", Optional.ofNullable(surname))
				.build();
		
		List<LibraryUser> libraryUserGroup = criteria.getFilter().isEmpty() ?
				allLibraryUserImpl.getAllLibraryUsers()
				:
				libraryUserByCriteriaImpl.getLibraryUserByCriteria(criteria);
		
		return LibraryUserGroupMapper.libraryUserGrouptoLibraryUserDtoGroup(libraryUserGroup);
	}
}
