package com.francisco.library_management.crud.application.ports.category;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.models.Category;

@Repository
public interface CreateCategoryRepository {
	
	public boolean createCategory(Category category);
	
}
