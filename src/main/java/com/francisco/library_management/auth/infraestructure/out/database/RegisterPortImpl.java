package com.francisco.library_management.auth.infraestructure.out.database;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.application.ports.RegisterPort;
import com.francisco.library_management.auth.domain.model.AuthUser;
import com.francisco.library_management.auth.domain.model.User;
import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.UserAlreadyRegisterException;
import com.francisco.library_management.auth.infraestructure.mappers.UserMapper;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;
import com.francisco.library_management.auth.infraestructure.out.database.repository.UserRepository;

@Repository
public class RegisterPortImpl implements RegisterPort {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private UserReaderPortImpl userReaderPortImpl;
	
	public RegisterPortImpl(UserRepository userRepository,
			PasswordEncoder passwordEncoder,
			UserReaderPortImpl userReaderPortImpl) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userReaderPortImpl = userReaderPortImpl;
	}
	
	@Override
	public User register(User user) {
		AuthUser userRepeat = userReaderPortImpl.findByUsername(user.getUsername());
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
