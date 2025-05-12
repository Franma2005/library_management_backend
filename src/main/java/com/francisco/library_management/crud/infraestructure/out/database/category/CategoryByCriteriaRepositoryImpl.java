package com.francisco.library_management.infraestructure.out.database.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.category.CategoryByCriteriaRepository;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.Filter;
import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.filters.command.registry.CategoryFilterCommandRegistry;
import com.francisco.library_management.infraestructure.filters.interfaces.MyCategoryCommand;
import com.francisco.library_management.infraestructure.mapper.CategoryGroupMapper;
import com.francisco.library_management.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.CategoryRepositoryDatabase;

@Repository
public class CategoryByCriteriaRepositoryImpl implements CategoryByCriteriaRepository {

	private CategoryRepositoryDatabase categoryRepositoryDatabase;
	private CategoryFilterCommandRegistry categoryFilterCommandRegistry;
	
	public CategoryByCriteriaRepositoryImpl(CategoryRepositoryDatabase categoryRepositoryDatabase, 
			CategoryFilterCommandRegistry categoryFilterCommandRegistry) {
		this.categoryRepositoryDatabase = categoryRepositoryDatabase;
		this.categoryFilterCommandRegistry = categoryFilterCommandRegistry;
	}

	@Override
	public List<Category> findCategoryByCriteria(Criteria criteria) {
		List<CategoryEntity> categoryEntityGroup = categoryRepositoryDatabase.findAll();
		List<Category> categoryGroup = mapToCategory(categoryEntityGroup);
		
		if(!criteria.getFilter().isEmpty())
			categoryGroup = filter(categoryGroup, criteria);
			
		return categoryGroup;
	}
	
	private List<Category> mapToCategory(List<CategoryEntity> categoryEntityGroup) {
		return CategoryGroupMapper.categoryEntityGrouptoCategoryGroup(categoryEntityGroup);
	}
	
	private List<Category> filter(List<Category> categoryGroup, Criteria criteria) {
		List<Category> categoryGroupFilter = new ArrayList<Category>();
		
		for (Category category : categoryGroup) {
			if(matchesCriteria(category, criteria.getFilter()))
				categoryGroupFilter.add(category);
				
		}
		
		return categoryGroupFilter;
	}
	
	private boolean matchesCriteria(Category category, List<Filter<?>> filters) {
		boolean allFiltersComplete = true;
		
		for (Filter<?> filter : filters) {
			if(!matchesFilter(category, filter))
				allFiltersComplete = false;
		}
		
		return allFiltersComplete;
	}
	
	private boolean matchesFilter(Category category, Filter<?> filter) {
		String field = filter.getField();
		Object value = filter.getValue();
		
		MyCategoryCommand myCategoryCommand = categoryFilterCommandRegistry.getCommand(field);
		return myCategoryCommand.execute(category, value);
	}
	
}
