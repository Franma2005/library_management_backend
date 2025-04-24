package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.infraestructure.recive.CategoryRecive;
import com.francisco.library_management.usecase.category.AllCategoriesUseCase;
import com.francisco.library_management.usecase.category.CreateCategoryUseCase;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private AllCategoriesUseCase allCategoriesUseCase;
	private CreateCategoryUseCase createCategoryUseCase;
	
	public CategoryController(AllCategoriesUseCase allCategoriesUseCase, CreateCategoryUseCase createCategoryUseCase) {
		this.allCategoriesUseCase = allCategoriesUseCase;
		this.createCategoryUseCase = createCategoryUseCase;
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
	
	public ResponseEntity<CategoryDto> createCategory(
			@RequestBody CategoryRecive categoryRecive
	) {
		return createCategoryUseCase.createCategory(categoryRecive);
	}
	
	public ResponseEntity<CategoryDto> updateCategory() {
		return null;
	}
	
	public ResponseEntity<CategoryDto> deleteCategory() {
		return null;
	}
	
}
