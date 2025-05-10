package com.francisco.library_management.auth.infraestructure.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.francisco.library_management.auth.domain.model.Role;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.authorities = List.of(new SimpleGrantedAuthority(role.name()));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
}
