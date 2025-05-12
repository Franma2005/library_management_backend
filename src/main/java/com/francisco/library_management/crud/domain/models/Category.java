package com.francisco.library_management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Category {
	private long id;
	private String category;
}
