package com.francisco.library_management.auth.infraestructure.out.database;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.application.ports.UserReaderPort;
import com.francisco.library_management.auth.domain.model.AuthUser;
import com.francisco.library_management.auth.infraestructure.mappers.AuthUserMapper;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;
import com.francisco.library_management.auth.infraestructure.out.database.repository.UserRepository;

@Repository
public class UserReaderPortImpl implements UserReaderPort {

	private UserRepository userRepository;
	
	public UserReaderPortImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public AuthUser findByUsername(String username) {
		UserEntity userEntity = userRepository.findByUsername(username);
		if(userEntity == null)
			return null;
		AuthUser authUser = mapToAuthUser(userEntity);
		return authUser;
	}
	
	private AuthUser mapToAuthUser(UserEntity userEntity) {
		return AuthUserMapper.userEntityToAuthUser(userEntity);
	}
	
}
