package com.francisco.library_management.crud.usecase.libraryUser;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.libraryUser.DeleteLibraryUserImpl;
import com.francisco.library_management.crud.application.services.libraryUser.LibraryUserByCriteriaImpl;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.crud.infraestructure.mapper.LibraryUserMapper;

@Component
public class DeleteLibraryUserUseCase {

	private DeleteLibraryUserImpl deleteLibraryUserImpl;
	private LibraryUserByCriteriaImpl libraryUserByCriteriaImpl;
	
	public DeleteLibraryUserUseCase(DeleteLibraryUserImpl deleteLibraryUserImpl,
			LibraryUserByCriteriaImpl libraryUserByCriteriaImpl) {
		this.deleteLibraryUserImpl = deleteLibraryUserImpl;
		this.libraryUserByCriteriaImpl = libraryUserByCriteriaImpl;
	}
	
	public LibraryUserDto deleteLibraryUser(Long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		List<LibraryUser> libraryUserGroup = 
				libraryUserByCriteriaImpl.getLibraryUserByCriteria(criteria);
		deleteLibraryUserImpl.deleteLibraryUser(id);
		return LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUserGroup.get(0));
	}
	
}
