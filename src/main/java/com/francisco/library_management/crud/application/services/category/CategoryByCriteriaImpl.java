package com.francisco.library_management.application.services.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.CategoryByCriteriaRepository;
import com.francisco.library_management.application.services.servicesInterfaces.category.CategoryByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Category;

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
