package com.francisco.library_management.crud.application.services.servicesInterfaces.category;

import java.util.List;

import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.models.Category;

public interface CategoryByCriteria {

	public List<Category> getCategoryByCriteria(Criteria criteria);
	
}
