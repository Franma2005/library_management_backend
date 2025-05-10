package com.francisco.library_management.auth.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.francisco.library_management.auth.infraestructure.security.UserReaderForConfiguration;

@Configuration
public class UserConfig {

	private final UserReaderForConfiguration userReaderForConfiguration;
	
	public UserConfig(UserReaderForConfiguration userReaderForConfiguration) {
		this.userReaderForConfiguration = userReaderForConfiguration;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		return daoAuthenticationProvider;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> userReaderForConfiguration.findUserDetailsImpl(username);
				
	}
	
}
