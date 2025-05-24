package com.francisco.library_management.crud.infraestructure.mapper;

import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.crud.infraestructure.dto.CategoryDto;
import com.francisco.library_management.crud.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.crud.infraestructure.recive.CategoryRecive;

public class CategoryMapper {

	public static Category categoryRecivetoCategory(CategoryRecive categoryRecive) {
		return Category.builder()
				.id(categoryRecive.getId())
				.category(categoryRecive.getCategory())
				.build();
	}
	
	public static Category categoryEntitytoCategory(CategoryEntity categoryEntity) {
		return Category.builder()
				.id(categoryEntity.getId())
				.category(categoryEntity.getCategory())
				.build();
	}
	
	public static CategoryDto categorytoCategoryDto(Category category) {
		return CategoryDto.builder()
				.id(category.getId())
				.category(category.getCategory())
				.build();
	}
	
	public static CategoryEntity categorytoCategoryEntity(Category category) {
		return CategoryEntity.builder()
				.id(category.getId())
				.category(category.getCategory())
				.build();
	}
	
}
