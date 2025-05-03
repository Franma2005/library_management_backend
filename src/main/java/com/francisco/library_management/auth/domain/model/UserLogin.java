package com.francisco.library_management.auth.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserLogin {
	
	private String username;
	private String password;
	
}
