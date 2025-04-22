package com.francisco.library_management.infraestructure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookDto {
	private long id;
	private String name;
	private String author;
	private String editorial;
	private long category;
}
