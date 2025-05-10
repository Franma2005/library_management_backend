package com.francisco.library_management.auth.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String country;
	private Role role;
	
}
