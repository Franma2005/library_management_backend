package com.francisco.library_management.auth.infraestructure.security.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthToken {

	private String token;
	
}
