package com.francisco.library_management.crud.usecase.category;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.category.CreateCategoryImpl;
import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.crud.infraestructure.dto.CategoryDto;
import com.francisco.library_management.crud.infraestructure.mapper.CategoryMapper;
import com.francisco.library_management.crud.infraestructure.recive.CategoryRecive;

@Component
public class CreateCategoryUseCase {

	private CreateCategoryImpl createCategoryImpl;
	
	public CreateCategoryUseCase(CreateCategoryImpl createCategoryImpl) {
		this.createCategoryImpl = createCategoryImpl;
	}
	
	public CategoryDto createCategory(CategoryRecive categoryRecive) {
		Category category = CategoryMapper.categoryRecivetoCategory(categoryRecive);
		createCategoryImpl.createCategory(category);
		CategoryDto categoryDto = CategoryMapper.categorytoCategoryDto(category);
		return categoryDto;
	}
}
