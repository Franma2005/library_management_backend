package com.francisco.library_management.auth.infraestructure.out.database;

import com.francisco.library_management.auth.application.services.ports.UserReaderPort;
import com.francisco.library_management.auth.domain.model.UserRegister;
import com.francisco.library_management.auth.infraestructure.mappers.UserEntityMapper;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;

public class UserReaderPortImpl implements UserReaderPort {

	private UserRepository userRepository;
	
	public UserReaderPortImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserRegister findByUsername(String username) {
		UserEntity userEntity = userRepository.findByUsername(username);
		if(userEntity == null)
			return null;
		UserRegister userRegister = UserEntityMapper.userEntityToUserRegister(userEntity);
		return userRegister;
	}
	
}
