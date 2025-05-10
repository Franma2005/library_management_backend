package com.francisco.library_management.auth.middleware;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.francisco.library_management.auth.infraestructure.security.jwt.JwtTokenValidator;
import com.francisco.library_management.auth.middleware.exceptions.AuthenticationTokenException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private static final String BEARER_PREFIX = "Bearer ";
	private static final int BEARER_PREFIX_LENGHT = BEARER_PREFIX.length();

	private final JwtTokenValidator jwtTokenValidator;
	
	public JwtAuthenticationFilter(JwtTokenValidator jwtTokenValidator) {
		this.jwtTokenValidator = jwtTokenValidator;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String token = extractToken(request);
		
		if(!jwtTokenValidator.isTokenValid(token))
			throw new AuthenticationTokenException();
		
		filterChain.doFilter(request, response);
	}

	private String extractToken(HttpServletRequest request) {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if(!StringUtils.hasText(authHeader) || !authHeader.startsWith(BEARER_PREFIX))
			return null;
		
		return authHeader.substring(BEARER_PREFIX_LENGHT);
	}

}
