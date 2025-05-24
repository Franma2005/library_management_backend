package com.francisco.library_management.crud.infraestructure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LibraryUserDto {
	private long id;
	private String name;
	private String surname;
}
