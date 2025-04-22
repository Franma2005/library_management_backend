package com.francisco.library_management.infraestructure.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.domain.models.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {

	public ResponseEntity<Category> getAllCategory(
			@RequestParam(required = false) long id,
			@RequestParam(required = false) String category
	) {
		return null;
	}
	
	public ResponseEntity<Category> createCategory() {
		return null;
	}
	
	public ResponseEntity<Category> updateCategory() {
		return null;
	}
	
	public ResponseEntity<Category> deleteCategory() {
		return null;
	}
	
}
