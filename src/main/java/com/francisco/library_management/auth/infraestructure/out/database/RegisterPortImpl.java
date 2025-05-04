package com.francisco.library_management.auth.infraestructure.out.database;

import com.francisco.library_management.auth.application.services.ports.RegisterPort;
import com.francisco.library_management.auth.domain.model.UserRegister;
import com.francisco.library_management.auth.infraestructure.mappers.UserEntityMapper;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;

public class RegisterPortImpl implements RegisterPort {
	
	private UserRepository userRepository;
	
	public RegisterPortImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserRegister register(UserRegister userRegister) {
		UserEntity userEntity = UserEntityMapper.userRegisterToUserEntity(userRegister);
		userRepository.save(userEntity);
		return userRegister;
	}

}
