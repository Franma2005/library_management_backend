package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.CategoryDto;
import com.francisco.library_management.infraestructure.recive.CategoryRecive;
import com.francisco.library_management.usecase.category.AllCategoriesUseCase;
import com.francisco.library_management.usecase.category.CreateCategoryUseCase;
import com.francisco.library_management.usecase.category.UploadCategoryUseCase;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private AllCategoriesUseCase allCategoriesUseCase;
	private CreateCategoryUseCase createCategoryUseCase;
	private UploadCategoryUseCase updateCategoryUseCase;
	
	public CategoryController(AllCategoriesUseCase allCategoriesUseCase, CreateCategoryUseCase createCategoryUseCase, UploadCategoryUseCase updateCategoryUseCase) {
		this.allCategoriesUseCase = allCategoriesUseCase;
		this.createCategoryUseCase = createCategoryUseCase;
		this.updateCategoryUseCase = updateCategoryUseCase;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String category
	) {
		return allCategoriesUseCase.findAllCategories(
				id,
				category
		);
	}
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(
			@RequestBody CategoryRecive categoryRecive
	) {
		return createCategoryUseCase.createCategory(categoryRecive);
	}
	
	@PutMapping("/")
	public ResponseEntity<CategoryDto> updateCategory(
			@RequestBody CategoryRecive categoryRecive		
	) {
		return updateCategoryUseCase.updateCategory(categoryRecive);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<CategoryDto> deleteCategory() {
		return null;
	}
	
}
