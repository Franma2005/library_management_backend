package com.francisco.library_management.auth.infraestructure;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	
	private static final String SECRET_KEY = "$2y$10$otHBGhXYt6vpQ4N.sv2kBOE96ij/S48RgqABFLrZQKzHUVDiJcRRG";
	
	public String getToken(UserDetails userDetails) {
		return getToken(new HashMap<>(), userDetails);
	}
	
	public String getToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts
				.builder()
				.claims(extraClaims)
				.subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000*60*24))
				.signWith(getKey())
				.compact();
	}

	private Key getKey() {
		byte[] keyByte = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyByte);
	}
	
}
