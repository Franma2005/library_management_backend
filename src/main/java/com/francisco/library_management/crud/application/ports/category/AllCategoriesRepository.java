package com.francisco.library_management.application.ports.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.Category;

@Repository
public interface AllCategoriesRepository {
	List<Category> getAllCategories();
}
