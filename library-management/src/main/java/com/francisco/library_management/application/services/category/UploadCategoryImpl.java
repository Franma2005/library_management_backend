package com.francisco.library_management.application.services.category;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.category.UploadCategoryRepository;
import com.francisco.library_management.application.ports.notification.NotificationCategoryPort;
import com.francisco.library_management.application.services.servicesInterfaces.category.UploadCategory;
import com.francisco.library_management.domain.models.Category;

@Service
public class UploadCategoryImpl implements UploadCategory {

	private UploadCategoryRepository uploadCategoryRepository;
	private NotificationCategoryPort notificationRepository;
	
	public UploadCategoryImpl(UploadCategoryRepository uploadCategoryRepository, NotificationCategoryPort notificationRepository) {
		this.uploadCategoryRepository = uploadCategoryRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void uploadCategory(Category category) {
		uploadCategoryRepository.uploadCategory(category);
		notificationRepository.notifyCategoryChanges();
	}
	
}
