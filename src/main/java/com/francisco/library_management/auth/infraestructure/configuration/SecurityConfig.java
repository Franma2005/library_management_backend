package com.francisco.library_management.auth.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.francisco.library_management.auth.middleware.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private JwtAuthenticationFilter jwtAuthenticationFilter;
	private AuthenticationProvider authenticationProvider;
	
	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
			AuthenticationProvider authenticationProvider) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.authenticationProvider = authenticationProvider;
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(this::disableCsrf)
				.authorizeHttpRequests(this::configureAuthorization)
				.sessionManagement(this::configureSessionManagement)
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter,
						UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	private void disableCsrf(
			CsrfConfigurer<HttpSecurity> csrf
	) {
	    csrf.disable();
	}
	
	private void configureAuthorization(
			AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth
	) {
	    auth.requestMatchers("/auth/**").permitAll()
	        .anyRequest().authenticated();
	}
	
	private void configureSessionManagement(SessionManagementConfigurer<HttpSecurity> session) {
	    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
