package com.francisco.library_management.crud.infraestructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.francisco.library_management.auth.middleware.JwtHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	private JwtHandshakeInterceptor jwtHandshakeInterceptor;
	
	public WebSocketConfiguration(JwtHandshakeInterceptor jwtHandshakeInterceptor) {
		this.jwtHandshakeInterceptor = jwtHandshakeInterceptor;
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/alert");
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/notifications")
				.addInterceptors(jwtHandshakeInterceptor)
				.setAllowedOrigins("*");
	}
	
}
