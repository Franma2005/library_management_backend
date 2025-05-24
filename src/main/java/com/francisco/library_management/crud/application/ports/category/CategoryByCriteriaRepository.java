package com.francisco.library_management.crud.application.ports.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.models.Category;

@Repository
public interface CategoryByCriteriaRepository {

	public List<Category> findCategoryByCriteria(Criteria criteria);
	
}
