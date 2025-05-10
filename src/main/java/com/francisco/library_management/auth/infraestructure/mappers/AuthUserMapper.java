package com.francisco.library_management.auth.infraestructure.mappers;

import com.francisco.library_management.auth.domain.model.AuthUser;
import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;
import com.francisco.library_management.auth.infraestructure.recive.AuthUserRecive;

public class AuthUserMapper {

	public static AuthUser userLoginRecivetoUserLogin(AuthUserRecive userLoginRecive) {
		return AuthUser.builder()
				.username(userLoginRecive.getUsername())
				.password(userLoginRecive.getPassword())
				.build();
	}

	public static UserEntity authUserToUserEntity(AuthUser authUser) {
		return UserEntity.builder()
				.username(authUser.getUsername())
				.password(authUser.getPassword())
				.role(authUser.getRole())
				.build();
	}

	public static AuthUser userEntityToAuthUser(UserEntity userEntity) {
		return AuthUser.builder()
				.username(userEntity.getUsername())
				.password(userEntity.getPassword())
				.role(userEntity.getRole())
				.build();
	}
	
}
