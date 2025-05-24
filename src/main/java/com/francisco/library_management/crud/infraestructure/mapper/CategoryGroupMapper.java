package com.francisco.library_management.crud.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.crud.infraestructure.dto.CategoryDto;
import com.francisco.library_management.crud.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.crud.infraestructure.recive.CategoryRecive;

public class CategoryGroupMapper {

	public static List<Category> categoryReciveGrouptoCategoryGroup(List<CategoryRecive> categoryReciveGroup) {
		List<Category> categoryGroup = new ArrayList<Category>();

		for (CategoryRecive categoryRecive : categoryReciveGroup) {
			categoryGroup.add(CategoryMapper.categoryRecivetoCategory(categoryRecive));
		}

		return categoryGroup;
	}

	public static List<Category> categoryEntityGrouptoCategoryGroup(List<CategoryEntity> categoryEntityGroup) {
		List<Category> categoryGroup = new ArrayList<Category>();

		for (CategoryEntity categoryEntity : categoryEntityGroup) {
			categoryGroup.add(CategoryMapper.categoryEntitytoCategory(categoryEntity));
		}

		return categoryGroup;
	}

	public static List<CategoryDto> categoryGrouptoCategoryDtoGroup(List<Category> categoryGroup) {
		List<CategoryDto> categoryDtoGroup = new ArrayList<CategoryDto>();

		for (Category category : categoryGroup) {
			categoryDtoGroup.add(CategoryMapper.categorytoCategoryDto(category));
		}

		return categoryDtoGroup;
	}

}
