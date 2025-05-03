package com.francisco.library_management.application.services.servicesInterfaces.category;

import java.util.List;

import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Category;

public interface CategoryByCriteria {

	public List<Category> getCategoryByCriteria(Criteria criteria);
	
}
