package com.francisco.library_management.usecase.category;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.category.UploadCategoryImpl;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.infraestructure.mapper.CategoryMapper;
import com.francisco.library_management.infraestructure.recive.CategoryRecive;

@Component
public class UploadCategoryUseCase {

	private UploadCategoryImpl updateCategoryImpl;
	
	public UploadCategoryUseCase(UploadCategoryImpl uploadCategoryImpl) {
		this.updateCategoryImpl = uploadCategoryImpl;
	}
	
	public ResponseEntity<CategoryDto> updateCategory(CategoryRecive categoryRecive) {
		Category category = CategoryMapper.categoryRecivetoCategory(categoryRecive);
		updateCategoryImpl.uploadCategory(category);
		CategoryDto categoryDto = CategoryMapper.categorytoCategoryDto(category);
		return ResponseEntity.ok(categoryDto);
	}
}
