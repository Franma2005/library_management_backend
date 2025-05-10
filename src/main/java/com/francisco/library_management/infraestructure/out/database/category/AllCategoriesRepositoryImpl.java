package com.francisco.library_management.infraestructure.out.database.category;

import java.util.List;

import com.francisco.library_management.application.ports.category.AllCategoriesRepository;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.mapper.CategoryGroupMapper;
import com.francisco.library_management.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.CategoryRepositoryDatabase;

public class AllCategoriesRepositoryImpl implements AllCategoriesRepository {

	private CategoryRepositoryDatabase categoryRepositoryDatabase;
	
	public AllCategoriesRepositoryImpl(CategoryRepositoryDatabase categoryRepositoryDatabase) {
		this.categoryRepositoryDatabase = categoryRepositoryDatabase;
	}

	@Override
	public List<Category> getAllCategories() {
		List<CategoryEntity> categoryEntityGroup = categoryRepositoryDatabase.findAll();
		List<Category> categoryGroup = mapToCategory(categoryEntityGroup);
		return categoryGroup;
	}
	
	private List<Category> mapToCategory(List<CategoryEntity> categoryEntityGroup) {
		return CategoryGroupMapper.categoryEntityGrouptoCategoryGroup(categoryEntityGroup);
	}
	
}
