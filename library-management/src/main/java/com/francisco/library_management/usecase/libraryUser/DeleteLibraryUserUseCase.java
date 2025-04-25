package com.francisco.library_management.usecase.libraryUser;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.libraryUser.DeleteLibraryUserImpl;
import com.francisco.library_management.application.services.libraryUser.LibraryUserByCriteriaImpl;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.mapper.LibraryUserMapper;

@Component
public class DeleteLibraryUserUseCase {

	private DeleteLibraryUserImpl deleteLibraryUserImpl;
	private LibraryUserByCriteriaImpl libraryUserByCriteriaImpl;
	
	public DeleteLibraryUserUseCase(DeleteLibraryUserImpl deleteLibraryUserImpl, LibraryUserByCriteriaImpl libraryUserByCriteriaImpl) {
		this.deleteLibraryUserImpl = deleteLibraryUserImpl;
		this.libraryUserByCriteriaImpl = libraryUserByCriteriaImpl;
	}
	
	public ResponseEntity<LibraryUserDto> deleteLibraryUser(Long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		List<LibraryUser> libraryUserGroup = libraryUserByCriteriaImpl.getLibraryUserByCriteria(criteria);
		deleteLibraryUserImpl.deleteLibraryUser(id);
		return ResponseEntity.ok(
				LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUserGroup.get(0))
		);
	}
	
}
