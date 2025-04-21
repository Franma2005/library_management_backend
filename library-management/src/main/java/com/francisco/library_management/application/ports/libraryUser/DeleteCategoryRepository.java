package com.francisco.library_management.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteCategoryRepository {
	void deleteCategory(long id);
}
