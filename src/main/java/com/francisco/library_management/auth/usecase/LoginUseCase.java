package com.francisco.library_management.auth.usecase;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.domain.model.AuthUser;
import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.LoginException;
import com.francisco.library_management.auth.infraestructure.mappers.AuthUserMapper;
import com.francisco.library_management.auth.infraestructure.recive.AuthUserRecive;
import com.francisco.library_management.auth.infraestructure.security.UserReaderForConfiguration;
import com.francisco.library_management.auth.infraestructure.security.jwt.AuthToken;
import com.francisco.library_management.auth.infraestructure.security.jwt.JwtTokenGenerator;

@Component
public class LoginUseCase {

	private final AuthenticationManager authenticationManager;
	private final UserReaderForConfiguration userReaderForConfiguration;
	private final JwtTokenGenerator jwtTokenGenerator;

	public LoginUseCase(AuthenticationManager authenticationManager,
			UserReaderForConfiguration userReaderForConfiguration, JwtTokenGenerator jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.userReaderForConfiguration = userReaderForConfiguration;
		this.jwtTokenGenerator = jwtUtils;
	}

	public AuthToken login(AuthUserRecive authUserRecive) {
		try {
			AuthUser userLogin = mapToUserLogin(authUserRecive);
			authenticate(userLogin);
			UserDetails userDetails = userReaderForConfiguration.findUserDetailsImpl(userLogin.getUsername());
			return createSuccessResponse(userDetails);
		} catch (AuthenticationException e) {
			throw new LoginException();
		}
	}

	private AuthUser mapToUserLogin(AuthUserRecive authUserRecive) {
		return AuthUserMapper.userLoginRecivetoUserLogin(authUserRecive);
	}

	private void authenticate(AuthUser userLogin) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
	}
	
	private AuthToken createSuccessResponse(UserDetails userDetails) {
        String token = jwtTokenGenerator.getToken(userDetails);
        AuthToken authToken = AuthToken.builder()
            .token(token)
            .build();
        
        return authToken;
    }

}
