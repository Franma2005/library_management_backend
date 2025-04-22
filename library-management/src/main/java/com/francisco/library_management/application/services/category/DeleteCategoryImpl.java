package com.francisco.library_management.application.services.category;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.DeleteCategoryRepository;
import com.francisco.library_management.application.services.servicesInterfaces.category.DeleteCategory;

@Service
public class DeleteCategoryImpl implements DeleteCategory {

	private DeleteCategoryRepository deleteCategoryRepository;
	
	public DeleteCategoryImpl(DeleteCategoryRepository deleteCategoryRepository) {
		this.deleteCategoryRepository = deleteCategoryRepository;
	}
	
	@Override
	public void deleteCategory(long id) {
		deleteCategoryRepository.deleteCategory(id);
	}

}
