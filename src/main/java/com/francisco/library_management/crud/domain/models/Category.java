package com.francisco.library_management.crud.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Category {
	private Long id;
	private String category;
}
