package com.francisco.library_management.usecase.libraryUser;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.libraryUser.AllLibraryUsersImpl;
import com.francisco.library_management.application.services.libraryUser.LibraryUserByCriteriaImpl;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.mapper.LibraryUserGroupMapper;

@Component
public class AllLibraryUserUseCase {

	private AllLibraryUsersImpl allLibraryUserImpl;
	private LibraryUserByCriteriaImpl libraryUserByCriteriaImpl;
	
	public AllLibraryUserUseCase(AllLibraryUsersImpl allLibraryUserImpl,
			LibraryUserByCriteriaImpl libraryUserByCriteriaImpl) {
		this.allLibraryUserImpl = allLibraryUserImpl;
		this.libraryUserByCriteriaImpl = libraryUserByCriteriaImpl;
	}
	
	public ResponseEntity<List<LibraryUserDto>> findLibraryUser(
			Long id,
			String name,
			String surname
	) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent(null, null)
				.build();
		
		List<LibraryUser> libraryUserGroup = criteria.getFilter().isEmpty() ?
				allLibraryUserImpl.getAllLibraryUsers()
				:
				libraryUserByCriteriaImpl.getLibraryUserByCriteria(criteria);
		
		return ResponseEntity.ok(
				LibraryUserGroupMapper.libraryUserGrouptoLibraryUserDtoGroup(libraryUserGroup)
			);
	}
}
