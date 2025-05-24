package com.francisco.library_management.crud.application.services.category;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.category.DeleteCategoryRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.category.DeleteCategory;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

@Service
public class DeleteCategoryImpl implements DeleteCategory {

	private DeleteCategoryRepository deleteCategoryRepository;
	private NotificationPort notificationPort;
	
	public DeleteCategoryImpl(
			DeleteCategoryRepository deleteCategoryRepository,
			NotificationPort notificationPort
	) {
		this.deleteCategoryRepository = deleteCategoryRepository;
		this.notificationPort = notificationPort;
	}
	
	@Override
	public void deleteCategory(Long id) {
		deleteCategoryRepository.deleteCategory(id);
		notificationPort.sendNotification(NotificationType.CATEGORYRELOAD);
	}

}
