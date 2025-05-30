package com.francisco.library_management.application.ports.category;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.Category;

@Repository
public interface UpdateCategoryRepository {
	boolean updateCategory(Category category);
}
