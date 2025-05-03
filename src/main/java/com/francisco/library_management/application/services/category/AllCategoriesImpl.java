package com.francisco.library_management.application.services.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.AllCategoriesRepository;
import com.francisco.library_management.application.services.servicesInterfaces.category.AllCategories;
import com.francisco.library_management.domain.models.Category;

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
