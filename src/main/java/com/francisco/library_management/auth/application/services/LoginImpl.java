package com.francisco.library_management.auth.application.services;

import org.springframework.stereotype.Service;

import com.francisco.library_management.auth.application.services.ports.LoginPort;
import com.francisco.library_management.auth.application.services.servicesInterfaces.Login;
import com.francisco.library_management.auth.domain.model.UserLogin;

@Service
public class LoginImpl implements Login {

	private LoginPort loginPort;
	
	public LoginImpl(LoginPort loginPort) {
		this.loginPort = loginPort;
	}
	
	@Override
	public UserLogin login(UserLogin userLogin) {
		return loginPort.login(userLogin);
	}

}
