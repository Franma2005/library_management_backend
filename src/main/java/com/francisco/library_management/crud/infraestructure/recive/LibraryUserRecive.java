package com.francisco.library_management.crud.infraestructure.recive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LibraryUserRecive {
	private long id;
	private String name;
	private String surname;
}
