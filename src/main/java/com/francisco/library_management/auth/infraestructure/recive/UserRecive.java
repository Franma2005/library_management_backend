package com.francisco.library_management.auth.infraestructure.recive;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRecive {

	@NotBlank private String username;
	@NotBlank private String password;
	@NotBlank private String firstName;
	@NotBlank private String lastName;
	@NotBlank private String country;
	
}
