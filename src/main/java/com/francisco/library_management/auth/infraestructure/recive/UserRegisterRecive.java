package com.francisco.library_management.auth.infraestructure.recive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRegisterRecive {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String country;
	
}
