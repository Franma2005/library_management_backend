package com.francisco.library_management.auth.infraestructure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "jwt.secret")
@Getter
@Setter
public class JwtProperties {
	private String key;
}
