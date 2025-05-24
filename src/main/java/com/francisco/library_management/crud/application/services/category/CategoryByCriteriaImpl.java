package com.francisco.library_management.crud.application.services.category;

import java.util.List;

import com.francisco.library_management.crud.domain.models.Category;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.category.CategoryByCriteriaRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.category.CategoryByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;

@Service
public class CategoryByCriteriaImpl implements CategoryByCriteria {

	private CategoryByCriteriaRepository categoryByCriteriaRepository;
	
	public CategoryByCriteriaImpl(CategoryByCriteriaRepository categoryByCriteriaRepository) {
		this.categoryByCriteriaRepository = categoryByCriteriaRepository;
	}
	
	@Override
	public List<Category> getCategoryByCriteria(Criteria criteria) {
		return categoryByCriteriaRepository.findCategoryByCriteria(criteria);
	}

}
