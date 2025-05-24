package com.francisco.library_management.crud.application.services.category;

import com.francisco.library_management.crud.domain.models.Category;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.category.UpdateCategoryRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.category.UpdateCategory;

@Service
public class UpdateCategoryImpl implements UpdateCategory {

	private UpdateCategoryRepository updateCategoryRepository;
	private NotificationCategoryPort notificationRepository;
	
	public UpdateCategoryImpl(UpdateCategoryRepository updateCategoryRepository) {
		this.updateCategoryRepository = updateCategoryRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void updateCategory(Category category) {
		updateCategoryRepository.updateCategory(category);
		notificationRepository.notifyCategoryChanges();
	}
	
}
