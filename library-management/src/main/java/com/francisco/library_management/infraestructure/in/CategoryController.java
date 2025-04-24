package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.usecase.category.AllCategoriesUseCase;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private AllCategoriesUseCase allCategoriesUseCase;
	
	public CategoryController(AllCategoriesUseCase allCategoriesUseCase) {
		this.allCategoriesUseCase = allCategoriesUseCase;
	}
	
	public ResponseEntity<List<CategoryDto>> getAllCategory(
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String category
	) {
		return allCategoriesUseCase.findAllCategories(
				id,
				category
		);
	}
	
	public ResponseEntity<CategoryDto> createCategory() {
		return null;
	}
	
	public ResponseEntity<CategoryDto> updateCategory() {
		return null;
	}
	
	public ResponseEntity<CategoryDto> deleteCategory() {
		return null;
	}
	
}
