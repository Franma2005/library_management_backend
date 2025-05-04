package com.francisco.library_management.auth.infraestructure.recive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserLoginRecive {

	private String username;
	private String password;
	
}
