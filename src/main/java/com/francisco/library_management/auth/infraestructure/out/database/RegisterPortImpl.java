package com.francisco.library_management.auth.infraestructure.out.database;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.application.services.ports.RegisterPort;
import com.francisco.library_management.auth.domain.model.UserRegister;
import com.francisco.library_management.auth.infraestructure.mappers.UserEntityMapper;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;

@Repository
public class RegisterPortImpl implements RegisterPort {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public RegisterPortImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserRegister register(UserRegister userRegister) {
		UserEntity userEntity = UserEntityMapper.userRegisterToUserEntity(userRegister);
		System.out.println("varios");
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userRepository.save(userEntity);
		return userRegister;
	}

}
