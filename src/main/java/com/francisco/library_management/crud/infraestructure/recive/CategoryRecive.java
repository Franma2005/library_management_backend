package com.francisco.library_management.crud.infraestructure.recive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CategoryRecive {
	private long id;
	private String category;
}
