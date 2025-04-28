package com.francisco.library_management.application.services.category;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.DeleteCategoryRepository;
import com.francisco.library_management.application.ports.notification.NotificationCategoryPort;
import com.francisco.library_management.application.services.servicesInterfaces.category.DeleteCategory;

@Service
public class DeleteCategoryImpl implements DeleteCategory {

	private DeleteCategoryRepository deleteCategoryRepository;
	private NotificationCategoryPort notificationRepository;
	
	public DeleteCategoryImpl(DeleteCategoryRepository deleteCategoryRepository,
			NotificationCategoryPort notificationRepository) {
		this.deleteCategoryRepository = deleteCategoryRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void deleteCategory(Long id) {
		deleteCategoryRepository.deleteCategory(id);
		notificationRepository.notifyCategoryChanges();
	}

}
