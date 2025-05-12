package com.francisco.library_management.infraestructure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CategoryDto {
	private long id;
	private String category;
}
