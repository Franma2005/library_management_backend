package com.francisco.library_management.auth.middleware;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.francisco.library_management.auth.middleware.exceptions.AuthenticationTokenException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String token = getTokenFromRequest(request);
		
		filterChain.doFilter(request, response);
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if(!StringUtils.hasText(authHeader) || !authHeader.startsWith("Bearer "))
			return null;
		
		return authHeader.substring(7);
	}

}
