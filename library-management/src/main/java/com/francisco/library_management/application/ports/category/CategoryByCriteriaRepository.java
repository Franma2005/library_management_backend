package com.francisco.library_management.application.ports.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Category;

@Repository
public interface CategoryByCriteriaRepository {

	public List<Category> findCategoryByCriteria(Criteria criteria);
	
}
