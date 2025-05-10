package com.francisco.library_management.auth.infraestructure.security.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "jwt.secret")
@Getter
@Setter
public class JwtTokenGenerator {
	
	private String key;
	private SecretKey secretKey;
	
	@PostConstruct
	public void init() {
		byte[] keyByte = Decoders.BASE64.decode(key);
		secretKey = Keys.hmacShaKeyFor(keyByte);
	}
	
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
				.signWith(secretKey)
				.compact();
	}
	
}
