package com.francisco.library_management.crud.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LibraryUser {
	private Long id;
	private String name;
	private String surname;
}
