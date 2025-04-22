package com.francisco.library_management.application.services.category;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.UploadCategoryRepository;
import com.francisco.library_management.application.services.servicesInterfaces.category.UploadCategory;
import com.francisco.library_management.domain.models.Category;

@Service
public class UploadCategoryImpl implements UploadCategory {

	private UploadCategoryRepository uploadCategoryRepository;
	
	public UploadCategoryImpl(UploadCategoryRepository uploadCategoryRepository) {
		this.uploadCategoryRepository = uploadCategoryRepository;
	}
	
	@Override
	public void uploadCategory(Category category) {
		uploadCategoryRepository.uploadCategory(category);
	}
	
}
