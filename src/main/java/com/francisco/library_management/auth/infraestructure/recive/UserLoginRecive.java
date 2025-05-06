package com.francisco.library_management.auth.infraestructure.recive;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class UserLoginRecive {

	private String username;
	private String password;
	
}
