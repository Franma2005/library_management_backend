package com.francisco.library_management.usecase.category;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.category.CreateCategoryImpl;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.infraestructure.mapper.CategoryMapper;
import com.francisco.library_management.infraestructure.recive.CategoryRecive;

public class CreateCategoryUseCase {

	private CreateCategoryImpl createCategoryImpl;
	
	public CreateCategoryUseCase(CreateCategoryImpl createCategoryImpl) {
		this.createCategoryImpl = createCategoryImpl;
	}
	
	public ResponseEntity<CategoryDto> createCategory(CategoryRecive categoryRecive) {
		Category category = CategoryMapper.categoryRecivetoCategory(categoryRecive);
		createCategoryImpl.createCategory(category);
		CategoryDto categoryDto = CategoryMapper.categorytoCategoryDto(category);
		return ResponseEntity.ok(categoryDto);
	}
}
