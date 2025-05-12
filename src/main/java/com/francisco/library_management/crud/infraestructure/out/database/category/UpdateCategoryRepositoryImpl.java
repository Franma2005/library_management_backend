package com.francisco.library_management.infraestructure.out.database.category;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.category.UpdateCategoryRepository;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.mapper.CategoryMapper;
import com.francisco.library_management.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.CategoryRepositoryDatabase;

@Repository
public class UpdateCategoryRepositoryImpl implements UpdateCategoryRepository {

	private CategoryRepositoryDatabase categoryRepositoryDatabase;
	
	public UpdateCategoryRepositoryImpl(CategoryRepositoryDatabase categoryRepositoryDatabase) {
		this.categoryRepositoryDatabase = categoryRepositoryDatabase;
	}
	
	@Override
	public boolean updateCategory(Category category) {
		CategoryEntity categoryEntity = mapToCategoryEntity(category);
		categoryRepositoryDatabase.save(categoryEntity);
		return true;
	}
	
	private CategoryEntity mapToCategoryEntity(Category category) {
		return CategoryMapper.categorytoCategoryEntity(category);
	}

}
