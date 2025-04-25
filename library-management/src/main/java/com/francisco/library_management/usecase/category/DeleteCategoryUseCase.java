package com.francisco.library_management.usecase.category;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.category.CategoryByCriteriaImpl;
import com.francisco.library_management.application.services.category.DeleteCategoryImpl;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.infraestructure.mapper.CategoryMapper;

@Component
public class DeleteCategoryUseCase {

	private DeleteCategoryImpl deleteCategoryImpl;
	private CategoryByCriteriaImpl categoryByCriteriaImpl;
	
	public DeleteCategoryUseCase(DeleteCategoryImpl deleteCategoryImpl, CategoryByCriteriaImpl categoryByCriteriaImpl) {
		this.deleteCategoryImpl = deleteCategoryImpl;
		this.categoryByCriteriaImpl = categoryByCriteriaImpl;
	}
	
	public ResponseEntity<CategoryDto> deleteCategory(Long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		List<Category> categoryGroup = categoryByCriteriaImpl.getCategoryByCriteria(criteria);
		deleteCategoryImpl.deleteCategory(id);
		return ResponseEntity.ok(
				CategoryMapper.categorytoCategoryDto(categoryGroup.get(0))
		);
	}
	
}
