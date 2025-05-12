package com.francisco.library_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.francisco.library_management.auth.infraestructure.configuration.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

}
