package com.francisco.library_management.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import com.francisco.library_management.domain.models.LibraryUser;
import com.francisco.library_management.infraestructure.dto.LibraryUserDto;
import com.francisco.library_management.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.infraestructure.recive.LibraryUserRecive;

public class LibraryUserGroupMapper {

	public static List<LibraryUser> libraryUserReciveGrouptoLibraryUserGroup(List<LibraryUserRecive> libraryUserReciveGroup) {
		List<LibraryUser> libraryUserGroup = new ArrayList<LibraryUser>();
		
		for (LibraryUserRecive libraryUserRecive : libraryUserReciveGroup) {
			libraryUserGroup.add(
					LibraryUserMapper.libraryUserRecivetoLibraryUser(libraryUserRecive)
			);
		}
		
		return libraryUserGroup;
	}
	
	public static List<LibraryUser> libraryUserEntityGrouptoLibraryUserGroup(List<LibraryUserEntity> libraryUserEntityGroup) {
		List<LibraryUser> libraryUserGroup = new ArrayList<LibraryUser>();
		
		for (LibraryUserEntity libraryUserEntity : libraryUserEntityGroup) {
			libraryUserGroup.add(
					LibraryUserMapper.libraryUserEntitytoLibraryUser(libraryUserEntity)
			);
		}
		
		return libraryUserGroup;
	}
	
	public static List<LibraryUserDto> libraryUserGrouptoLibraryUserDtoGroup(List<LibraryUser> libraryUserGroup) {
		List<LibraryUserDto> libraryUserDtoGroup = new ArrayList<LibraryUserDto>();
		
		for (LibraryUser libraryUser : libraryUserGroup) {
			libraryUserDtoGroup.add(
					LibraryUserMapper.libraryUsertoLibraryUserDto(libraryUser)
			);
		}
		
		return libraryUserDtoGroup;
	}
	
}
