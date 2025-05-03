package com.francisco.library_management.application.ports.category;

import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends AllCategoriesRepository, CategoryByCriteriaRepository, CreateCategoryRepository, UpdateCategoryRepository, DeleteCategoryRepository {

}
