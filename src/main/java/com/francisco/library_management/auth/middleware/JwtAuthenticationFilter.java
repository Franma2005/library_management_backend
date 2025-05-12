package com.francisco.library_management.auth.middleware;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.francisco.library_management.auth.infraestructure.exceptions.TokenModifiedExceptionHandler;
import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.TokenModifiedException;
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

	private final TokenModifiedExceptionHandler tokenModifiedExceptionHandler;
	private final JwtTokenValidator jwtTokenValidator;
	
	public JwtAuthenticationFilter(TokenModifiedExceptionHandler tokenModifiedExceptionHandler,
			JwtTokenValidator jwtTokenValidator) {
		this.tokenModifiedExceptionHandler = tokenModifiedExceptionHandler;
		this.jwtTokenValidator = jwtTokenValidator;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String token = extractToken(request);
		try {
			if(token != null) {
				validateToken(token);
				UsernamePasswordAuthenticationToken authToken =
						new UsernamePasswordAuthenticationToken(jwtTokenValidator.extractUsername(token), null, null);
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
			
			filterChain.doFilter(request, response);
		} catch(TokenModifiedException tokenModifiedException) {
			response = tokenModifiedExceptionHandler.tokenModifiedExceptionHandle(response, tokenModifiedException);
		}
			
	}

	private String extractToken(HttpServletRequest request) {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if(!StringUtils.hasText(authHeader) || !authHeader.startsWith(BEARER_PREFIX))
			return null;
		
		return authHeader.substring(BEARER_PREFIX_LENGHT);
	}
	
	private void validateToken(String token) throws TokenModifiedException {
			boolean isValid = jwtTokenValidator.isTokenValid(token);
		    
			if(!isValid)
				throw new AuthenticationTokenException();
	}

}
