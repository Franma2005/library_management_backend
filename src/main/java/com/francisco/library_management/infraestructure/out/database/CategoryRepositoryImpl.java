package com.francisco.library_management.infraestructure.out.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.category.CategoryRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findCategoryByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
