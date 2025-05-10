package com.francisco.library_management.auth.usecase;

import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.application.services.servicesInterfaces.Register;
import com.francisco.library_management.auth.domain.model.User;
import com.francisco.library_management.auth.infraestructure.mappers.UserMapper;
import com.francisco.library_management.auth.infraestructure.recive.UserRecive;
import com.francisco.library_management.auth.infraestructure.security.UserDetailsImpl;
import com.francisco.library_management.auth.infraestructure.security.jwt.AuthToken;
import com.francisco.library_management.auth.infraestructure.security.jwt.JwtTokenGenerator;

@Component
public class RegisterUseCase {

	private final Register register;
	private final JwtTokenGenerator jwtTokenGenerator;
	
	public RegisterUseCase(Register register, JwtTokenGenerator jwtUtils) {
		this.register = register;
		this.jwtTokenGenerator = jwtUtils;
	}

	public AuthToken register(UserRecive userRecive) {
		User user = mapToUserRegister(userRecive);
		register.register(user);
		return createSuccessResponse(user);
	}
	
	private User mapToUserRegister(UserRecive userRecive) {
		return UserMapper.userRegisterRecivetoUserRegister(userRecive);
	}
	
	private AuthToken createSuccessResponse(User user) {
		return AuthToken.builder()
				.token(
					jwtTokenGenerator.getToken(
						new UserDetailsImpl(
							user.getUsername(),
							user.getPassword(),
							user.getRole()
						)
					)
				)
				.build();
	}
	
}
