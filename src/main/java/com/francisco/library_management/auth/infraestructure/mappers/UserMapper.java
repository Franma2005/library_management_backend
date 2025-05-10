package com.francisco.library_management.auth.infraestructure.mappers;

import com.francisco.library_management.auth.domain.model.Role;
import com.francisco.library_management.auth.domain.model.User;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;
import com.francisco.library_management.auth.infraestructure.recive.UserRecive;

public class UserMapper {

	public static User userRegisterRecivetoUserRegister(UserRecive userRegisterRecive) {
		return User.builder()
				.username(userRegisterRecive.getUsername())
				.password(userRegisterRecive.getPassword())
				.firstName(userRegisterRecive.getFirstName())
				.lastName(userRegisterRecive.getLastName())
				.country(userRegisterRecive.getCountry())
				.role(Role.USER)
				.build();
	}

	public static UserEntity userToUserEntity(User user) {
		return UserEntity.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.country(user.getCountry())
				.role(user.getRole())
				.build();
	}

	public static User userEntityToUser(UserEntity userEntity) {
		return User.builder()
				.username(userEntity.getUsername())
				.password(userEntity.getPassword())
				.firstName(userEntity.getFirstName())
				.lastName(userEntity.getLastName())
				.country(userEntity.getCountry())
				.role(userEntity.getRole())
				.build();
	}
	
}
