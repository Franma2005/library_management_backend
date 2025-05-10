package com.francisco.library_management.infraestructure.out.database.category;

import com.francisco.library_management.application.ports.category.CreateCategoryRepository;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.mapper.CategoryMapper;
import com.francisco.library_management.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.CategoryRepositoryDatabase;

public class CreateCategoryRepositoryImpl implements CreateCategoryRepository {

	private CategoryRepositoryDatabase categoryRepositoryDatabase;
	
	public CreateCategoryRepositoryImpl(CategoryRepositoryDatabase categoryRepositoryDatabase) {
		this.categoryRepositoryDatabase = categoryRepositoryDatabase;
	}

	@Override
	public boolean createCategory(Category category) {
		CategoryEntity categoryEntity = mapToCategoryEntity(category);
		categoryRepositoryDatabase.save(categoryEntity);
		return true;
	}
	
	private CategoryEntity mapToCategoryEntity(Category category) {
		return CategoryMapper.categorytoCategoryEntity(category);
	}
	
}
