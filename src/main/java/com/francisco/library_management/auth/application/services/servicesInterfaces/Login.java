package com.francisco.library_management.auth.application.services.servicesInterfaces;

import com.francisco.library_management.auth.domain.model.UserLogin;

public interface Login {

	public UserLogin login(UserLogin userLogin);
	
}
