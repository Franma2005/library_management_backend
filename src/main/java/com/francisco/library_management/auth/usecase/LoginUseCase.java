package com.francisco.library_management.auth.usecase;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.infraestructure.AuthToken;
import com.francisco.library_management.auth.infraestructure.JwtUtils;
import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.LoginException;
import com.francisco.library_management.auth.infraestructure.mappers.UserLoginMapper;
import com.francisco.library_management.auth.infraestructure.recive.UserLoginRecive;
import com.francisco.library_management.auth.infraestructure.security.UserReaderForConfiguration;

@Component
public class LoginUseCase {

	private AuthenticationManager authenticationManager;
	private UserReaderForConfiguration userReaderForConfiguration;
	private JwtUtils jwtUtils;

	public LoginUseCase(AuthenticationManager authenticationManager,
			UserReaderForConfiguration userReaderForConfiguration, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.userReaderForConfiguration = userReaderForConfiguration;
		this.jwtUtils = jwtUtils;
	}

	public ResponseEntity<AuthToken> login(UserLoginRecive userLoginRecive) {
		try {
			UserLogin userLogin = mapToUserLogin(userLoginRecive);
			authenticate(userLogin);

			UserDetails userDetails = userReaderForConfiguration.findUserDetailsImpl(userLogin.getUsername());
			return createSuccessResponse(userDetails);
		} catch (AuthenticationException e) {
			throw new LoginException();
		}
	}

	private UserLogin mapToUserLogin(UserLoginRecive userLoginRecive) {
		return UserLoginMapper.userLoginRecivetoUserLogin(userLoginRecive);
	}

	private void authenticate(UserLogin userLogin) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
	}
	
	private ResponseEntity<AuthToken> createSuccessResponse(UserDetails userDetails) {
        String token = jwtUtils.getToken(userDetails);
        AuthToken authToken = AuthToken.builder()
            .token(token)
            .build();
        
        return ResponseEntity.ok(authToken);
    }

}
