package com.francisco.library_management.auth.application.services;

import org.springframework.stereotype.Service;

import com.francisco.library_management.auth.application.services.ports.RegisterPort;
import com.francisco.library_management.auth.application.services.servicesInterfaces.Register;
import com.francisco.library_management.auth.domain.model.UserRegister;

@Service
public class RegisterImpl implements Register {

	private RegisterPort registerPort;
	
	public RegisterImpl(RegisterPort registerPort) {
		this.registerPort = registerPort;
	}
	
	@Override
	public UserRegister register(UserRegister userRegister) {
		return registerPort.register(userRegister);
	}

}
