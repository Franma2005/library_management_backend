package com.francisco.library_management.auth.infraestructure.mappers;

import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.domain.model.UserRegister;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;

public class UserEntityMapper {

	public static UserEntity userRegisterToUserEntity(UserRegister userRegister) {
		return UserEntity.builder()
				.username(userRegister.getUsername())
				.password(userRegister.getPassword())
				.firstName(userRegister.getFirstName())
				.lastName(userRegister.getLastName())
				.country(userRegister.getCountry())
				.role(userRegister.getRole())
				.build();
	}
	
	public static UserLogin userEntityToUserLogin(UserEntity userEntity) {
		return UserLogin.builder()
				.username(userEntity.getUsername())
				.password(userEntity.getPassword())
				.role(userEntity.getRole())
				.build();
	}

	
	public static UserRegister userEntityToUserRegister(UserEntity userEntity) {
		return UserRegister.builder()
				.username(userEntity.getUsername())
				.password(userEntity.getPassword())
				.firstName(userEntity.getFirstName())
				.lastName(userEntity.getLastName())
				.country(userEntity.getCountry())
				.role(userEntity.getRole())
				.build();
	}
	
}
