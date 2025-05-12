package com.francisco.library_management.infraestructure.out.database.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.category.DeleteCategoryRepository;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.mapper.CategoryMapper;
import com.francisco.library_management.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.CategoryRepositoryDatabase;

@Repository
public class DeleteCategoryRepositoryImpl implements DeleteCategoryRepository {

	private CategoryRepositoryDatabase categoryRepositoryDatabase;
	private CategoryByCriteriaRepositoryImpl categoryByCriteriaRepositoryImpl;
	
	public DeleteCategoryRepositoryImpl(CategoryRepositoryDatabase categoryRepositoryDatabase,
			CategoryByCriteriaRepositoryImpl categoryByCriteriaRepositoryImpl) {
		this.categoryRepositoryDatabase = categoryRepositoryDatabase;
		this.categoryByCriteriaRepositoryImpl = categoryByCriteriaRepositoryImpl;
	}
	
	@Override
	public boolean deleteCategory(long id) {
		Category category = getCategoryForDelete(id);
		CategoryEntity categoryEntity = mapToCategoryEntity(category);
		categoryRepositoryDatabase.delete(categoryEntity);
		return true;
	}
	
	private CategoryEntity mapToCategoryEntity(Category category) {
		return CategoryMapper.categorytoCategoryEntity(category);
	}
	
	private Category getCategoryForDelete(long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.of(id))
				.build();
		List<Category> category =
				categoryByCriteriaRepositoryImpl.findCategoryByCriteria(criteria);
		return category.get(0);
	}

}
