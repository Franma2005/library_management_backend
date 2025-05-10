package com.francisco.library_management.auth.infraestructure.out.database;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.application.services.ports.RegisterPort;
import com.francisco.library_management.auth.domain.model.User;
import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.UserAlreadyRegisterException;
import com.francisco.library_management.auth.infraestructure.mappers.UserMapper;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;
import com.francisco.library_management.auth.infraestructure.out.database.repository.UserRepository;
import com.francisco.library_management.auth.infraestructure.security.UserDetailsImpl;
import com.francisco.library_management.auth.infraestructure.security.UserReaderForConfiguration;

@Repository
public class RegisterPortImpl implements RegisterPort {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private UserReaderForConfiguration userReaderForConfiguration;
	
	public RegisterPortImpl(UserRepository userRepository,
			PasswordEncoder passwordEncoder,
			UserReaderForConfiguration userReaderForConfiguration) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userReaderForConfiguration = userReaderForConfiguration;
	}
	
	@Override
	public User register(User user) {
		UserDetailsImpl userRepeat = userReaderForConfiguration.findUserDetailsImpl(user.getUsername());
		if(userRepeat != null)
			throw new UserAlreadyRegisterException(userRepeat.getUsername());
		UserEntity userEntity = mapToUserEntity(user);
		encodePassword(userEntity);
		userRepository.save(userEntity);
		return user;
	}
	
	private UserEntity mapToUserEntity(User user) {
		return UserMapper.userToUserEntity(user);
	}
	
	private void encodePassword(UserEntity userEntity) {
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
	}

}
