package com.francisco.library_management.crud.application.services.category;

import com.francisco.library_management.crud.domain.models.Category;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.category.CreateCategoryRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.category.CreateCategory;

@Service
public class CreateCategoryImpl implements CreateCategory {

	private CreateCategoryRepository createCategoryRepository;
	private NotificationCategoryPort notificationRepository;
	
	public CreateCategoryImpl(CreateCategoryRepository createCategoryRepository) {
		this.createCategoryRepository = createCategoryRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void createCategory(Category category) {
		createCategoryRepository.createCategory(category);
		notificationRepository.notifyCategoryChanges();
	}

	
}
