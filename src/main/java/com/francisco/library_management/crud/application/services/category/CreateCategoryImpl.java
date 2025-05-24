package com.francisco.library_management.crud.application.services.category;

import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.category.CreateCategoryRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.category.CreateCategory;

@Service
public class CreateCategoryImpl implements CreateCategory {

	private CreateCategoryRepository createCategoryRepository;
	private NotificationPort notificationPort;
	
	public CreateCategoryImpl(
			CreateCategoryRepository createCategoryRepository,
			NotificationPort notificationPort
	) {
		this.createCategoryRepository = createCategoryRepository;
		this.notificationPort = notificationPort;
	}
	
	@Override
	public void createCategory(Category category) {
		createCategoryRepository.createCategory(category);
		notificationPort.sendNotification(NotificationType.CATEGORYRELOAD);
	}

}
