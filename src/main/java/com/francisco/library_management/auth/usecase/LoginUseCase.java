package com.francisco.library_management.auth.usecase;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.application.services.servicesInterfaces.Login;
import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.infraestructure.AuthToken;
import com.francisco.library_management.auth.infraestructure.JwtUtils;
import com.francisco.library_management.auth.infraestructure.mappers.UserLoginMapper;
import com.francisco.library_management.auth.infraestructure.recive.UserLoginRecive;
import com.francisco.library_management.auth.infraestructure.security.UserReaderForConfiguration;

@Component
public class LoginUseCase {

	private Login login;
	private AuthenticationManager authenticationManager;
	private UserReaderForConfiguration userReaderForConfiguration;
	private JwtUtils jwtUtils;
	
	public LoginUseCase(Login login, AuthenticationManager authenticationManager, UserReaderForConfiguration userReaderForConfiguration, JwtUtils jwtUtils) {
		this.login = login;
		this.authenticationManager = authenticationManager;
		this.userReaderForConfiguration = userReaderForConfiguration;
		this.jwtUtils = jwtUtils;
	}
	
	public ResponseEntity<AuthToken> login(UserLoginRecive userLoginRecive) {
		System.out.println("hola");
		UserLogin userLogin = UserLoginMapper.userLoginRecivetoUserLogin(userLoginRecive);
		System.out.println("joder");
		System.out.println(userLoginRecive.toString());
		try {
		    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
		} catch (AuthenticationException e) {
		    // Log para diagnosticar el problema
		    System.out.println("Error en la autenticación: " + e.getMessage());
		    return ResponseEntity.badRequest().build();
		}
		System.out.println("paco2");
		UserDetails userDetails = userReaderForConfiguration.findUserDetailsImpl(userLogin.getUsername());
		String token = jwtUtils.getToken(userDetails);
		System.out.println("Paco" + token);
		return ResponseEntity.ok(
					AuthToken.builder()
					.token(
						token
					)
					.build()
		);
	}
	
}
