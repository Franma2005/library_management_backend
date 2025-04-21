package com.francisco.library_management.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.Category;

@Repository
public interface UploadCategoryRepository {
	void uploadCategory(Category category);
}
