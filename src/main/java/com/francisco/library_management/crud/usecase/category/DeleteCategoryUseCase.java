package com.francisco.library_management.crud.usecase.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.category.CategoryByCriteriaImpl;
import com.francisco.library_management.crud.application.services.category.DeleteCategoryImpl;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.crud.infraestructure.dto.CategoryDto;
import com.francisco.library_management.crud.infraestructure.mapper.CategoryMapper;

@Component
public class DeleteCategoryUseCase {

	private DeleteCategoryImpl deleteCategoryImpl;
	private CategoryByCriteriaImpl categoryByCriteriaImpl;
	
	public DeleteCategoryUseCase(DeleteCategoryImpl deleteCategoryImpl,
			CategoryByCriteriaImpl categoryByCriteriaImpl) {
		this.deleteCategoryImpl = deleteCategoryImpl;
		this.categoryByCriteriaImpl = categoryByCriteriaImpl;
	}
	
	public CategoryDto deleteCategory(Long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		List<Category> categoryGroup = categoryByCriteriaImpl.getCategoryByCriteria(criteria);
		deleteCategoryImpl.deleteCategory(id);
		return CategoryMapper.categorytoCategoryDto(categoryGroup.get(0));
	}
	
}
