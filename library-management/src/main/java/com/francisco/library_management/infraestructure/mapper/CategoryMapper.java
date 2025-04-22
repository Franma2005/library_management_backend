package com.francisco.library_management.infraestructure.mapper;

import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.infraestructure.recive.CategoryRecive;

public class CategoryMapper {

	public static Category categoryRecivetoCategory(CategoryRecive categoryRecive) {
		return Category.builder()
				.id(categoryRecive.getId())
				.category(categoryRecive.getCategory())
				.build();
	}
	
	public static CategoryDto categorytoCategoryDto(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.category(category.getCategory())
				.build();
	}
}
