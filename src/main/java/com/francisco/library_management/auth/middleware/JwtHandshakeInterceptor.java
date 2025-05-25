package com.francisco.library_management.auth.middleware;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.francisco.library_management.auth.infraestructure.security.jwt.JwtTokenValidator;

@Component
public class JwtHandshakeInterceptor implements HandshakeInterceptor {

	private JwtTokenValidator jwtTokenValidator;
	
	public JwtHandshakeInterceptor(JwtTokenValidator jwtTokenValidator) {
		this.jwtTokenValidator = jwtTokenValidator;
	}
	
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		String token = null;
		boolean isTokenValid = false;
		
		if(request instanceof ServletServerHttpRequest servletRequest)
			token = servletRequest.getServletRequest().getParameter("token");
		
		if(token != null && jwtTokenValidator.isTokenValid(token)) {
			String username = jwtTokenValidator.extractUsername(token);
			attributes.put("username", username);
			isTokenValid = true;
		}
			
		System.out.println(isTokenValid);
		return isTokenValid;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
				
	}

}
