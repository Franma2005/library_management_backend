package com.francisco.library_management.auth.infraestructure.recive;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserRecive {

	@NonNull private String username;
	@NonNull private String password;
	
}
