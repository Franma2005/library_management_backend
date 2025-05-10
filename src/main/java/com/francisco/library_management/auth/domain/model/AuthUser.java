package com.francisco.library_management.auth.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class AuthUser {
	
	private String username;
	private String password;
	private Role role;
	
}
