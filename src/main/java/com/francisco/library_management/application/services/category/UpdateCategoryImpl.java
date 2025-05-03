package com.francisco.library_management.application.services.category;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.UpdateCategoryRepository;
import com.francisco.library_management.application.services.servicesInterfaces.category.UpdateCategory;
import com.francisco.library_management.domain.models.Category;

@Service
public class UpdateCategoryImpl implements UpdateCategory {

	private UpdateCategoryRepository updateCategoryRepository;
	//private NotificationCategoryPort notificationRepository;
	
	public UpdateCategoryImpl(UpdateCategoryRepository updateCategoryRepository) {
		this.updateCategoryRepository = updateCategoryRepository;
		//this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void updateCategory(Category category) {
		updateCategoryRepository.updateCategory(category);
		//notificationRepository.notifyCategoryChanges();
	}
	
}
