package com.francisco.library_management.crud.application.ports.category;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteCategoryRepository {
	
	public boolean deleteCategory(long id);
	
}
