package com.francisco.library_management.auth.infraestructure.out.database;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.application.services.ports.UserReaderPort;
import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.infraestructure.mappers.UserEntityMapper;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;

@Repository
public class UserReaderPortImpl implements UserReaderPort {

	private UserRepository userRepository;
	
	public UserReaderPortImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserLogin findByUsername(String username) {
		UserEntity userEntity = userRepository.findByUsername(username);
		if(userEntity == null) {
			System.out.println("user entity is null");
			return null;
		}
		UserLogin userLogin = UserEntityMapper.userEntityToUserLogin(userEntity);
		return userLogin;
	}
	
}
