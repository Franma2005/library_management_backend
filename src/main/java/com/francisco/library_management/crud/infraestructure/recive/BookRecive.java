package com.francisco.library_management.crud.infraestructure.recive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookRecive {
	private long id;
	private String name;
	private String author;
	private String editorial;
	private long category;
}
