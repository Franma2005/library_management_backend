package com.francisco.library_management.crud.application.services.category;

import java.util.List;

import com.francisco.library_management.crud.domain.models.Category;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.category.AllCategoriesRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.category.AllCategories;

@Service
public class AllCategoriesImpl implements AllCategories {

	private AllCategoriesRepository allCategoriesRepository;
	
	public AllCategoriesImpl(AllCategoriesRepository allCategoriesRepository) {
		this.allCategoriesRepository = allCategoriesRepository;
	}
	
	@Override
	public List<Category> getAllCategories() {
		return allCategoriesRepository.getAllCategories();
	}

}
