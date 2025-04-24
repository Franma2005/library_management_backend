package com.francisco.library_management.usecase.category;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.category.CreateCategoryImpl;
import com.francisco.library_management.infraestructure.dto.CategoryDto;

public class CreateCategoryUseCase {

	private CreateCategoryImpl createCategoryImpl;
	
	public CreateCategoryUseCase(CreateCategoryImpl createCategoryImpl) {
		this.createCategoryImpl = createCategoryImpl;
	}
	
	public ResponseEntity<CategoryDto> createCategory() {
		
	}
}
