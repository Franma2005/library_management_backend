package com.francisco.library_management.crud.application.services.category;

import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.category.UpdateCategoryRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.category.UpdateCategory;

@Service
public class UpdateCategoryImpl implements UpdateCategory {

	private UpdateCategoryRepository updateCategoryRepository;
	private NotificationPort notificationPort;
	
	public UpdateCategoryImpl(
			UpdateCategoryRepository updateCategoryRepository,
			NotificationPort notificationPort
	) {
		this.updateCategoryRepository = updateCategoryRepository;
		this.notificationPort = notificationPort;
		
	}
	
	@Override
	public void updateCategory(Category category) {
		updateCategoryRepository.updateCategory(category);
		notificationPort.sendNotification(NotificationType.CATEGORYRELOAD);
	}
	
}
