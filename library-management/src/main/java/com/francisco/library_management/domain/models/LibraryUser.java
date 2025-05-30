package com.francisco.library_management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LibraryUser {
	private long id;
	private String name;
	private String surname;
}
