package com.francisco.library_management.application.services.category;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.CreateCategoryRepository;
import com.francisco.library_management.application.services.servicesInterfaces.category.CreateCategory;
import com.francisco.library_management.domain.models.Category;

@Service
public class CreateCategoryImpl implements CreateCategory {

	private CreateCategoryRepository createCategoryRepository;
	//private NotificationCategoryPort notificationRepository;
	
	public CreateCategoryImpl(CreateCategoryRepository createCategoryRepository) {
		this.createCategoryRepository = createCategoryRepository;
		//this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void createCategory(Category category) {
		createCategoryRepository.createCategory(category);
		//notificationRepository.notifyCategoryChanges();
	}

	
}
