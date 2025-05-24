package com.francisco.library_management.crud.usecase.category;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.category.UpdateCategoryImpl;
import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.crud.infraestructure.dto.CategoryDto;
import com.francisco.library_management.crud.infraestructure.mapper.CategoryMapper;
import com.francisco.library_management.crud.infraestructure.recive.CategoryRecive;

@Component
public class UpdateCategoryUseCase {

	private UpdateCategoryImpl updateCategoryImpl;
	
	public UpdateCategoryUseCase(UpdateCategoryImpl uploadCategoryImpl) {
		this.updateCategoryImpl = uploadCategoryImpl;
	}
	
	public CategoryDto updateCategory(CategoryRecive categoryRecive) {
		Category category = CategoryMapper.categoryRecivetoCategory(categoryRecive);
		updateCategoryImpl.updateCategory(category);
		CategoryDto categoryDto = CategoryMapper.categorytoCategoryDto(category);
		return categoryDto;
	}
}
