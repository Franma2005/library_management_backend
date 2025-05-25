package com.francisco.library_management.crud.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Book {
	private Long id;
	private String name;
	private String author;
	private String editorial;
	private Long categoryId;
	private Category category;
}
