package com.francisco.library_management.usecase.category;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.category.AllCategoriesImpl;
import com.francisco.library_management.application.services.category.CategoryByCriteriaImpl;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.infraestructure.mapper.CategoryGroupMapper;

public class AllCategoriesUseCase {

	private AllCategoriesImpl allCategoriesImpl;
	private CategoryByCriteriaImpl categoryByCriteriaImpl;
	
	public AllCategoriesUseCase(AllCategoriesImpl allCategoriesImpl, CategoryByCriteriaImpl categoryByCriteriaImpl) {
		this.allCategoriesImpl = allCategoriesImpl;
		this.categoryByCriteriaImpl = categoryByCriteriaImpl;
	}
	
	public ResponseEntity<List<CategoryDto>> findAllCategories(
			long id,
			String category
	) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.addFilterIfPresent("category", Optional.ofNullable(category))
				.build();
		
		List<Category> categoryReciveGroup = criteria.getFilter().isEmpty() ?
				allCategoriesImpl.getAllCategories()
				:
				categoryByCriteriaImpl.getCategoryByCriteria(criteria);
		
		List<CategoryDto> categoryDto = CategoryGroupMapper.categoryGrouptoCategoryDtoGroup(categoryReciveGroup);
		
		return ResponseEntity.ok(categoryDto);
	}
}
