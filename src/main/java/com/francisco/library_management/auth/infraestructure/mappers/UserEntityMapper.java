package com.francisco.library_management.auth.infraestructure.mappers;

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
	
	public static UserRegister userEntityToUserRegister(UserEntity userEntity) {
		return UserRegister.builder()
				.username(null)
				.password(null)
				.firstName(null)
				.lastName(null)
				.country(null)
				.role(null)
				.build();
	}
	
}
