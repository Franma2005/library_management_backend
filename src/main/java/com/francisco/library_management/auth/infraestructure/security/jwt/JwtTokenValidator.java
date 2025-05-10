package com.francisco.library_management.auth.infraestructure.security.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;

import com.francisco.library_management.auth.infraestructure.security.UserReaderForConfiguration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "jwt.secret")
@Getter
@Setter
public class JwtTokenValidator {

	private String key;
	private SecretKey secretKey;

	private UserReaderForConfiguration userReaderForConfiguration;
	
	public JwtTokenValidator(UserReaderForConfiguration userReaderForConfiguration) {
		this.userReaderForConfiguration = userReaderForConfiguration;
	}
	
	@PostConstruct
	private void init() {
		byte[] keyByte = Decoders.BASE64.decode(key);
		secretKey = Keys.hmacShaKeyFor(keyByte);
	}
	
	public boolean isTokenValid(String token) {
			final String username = extractUsername(token);
			
			final UserDetails userDetails = userReaderForConfiguration.findUserDetailsImpl(username);
			
			return userDetails != null
					&&
					!isTokenExpired(token);
	}
	
	private String extractUsername(String token) {
		return extractClaims(token).getSubject();
	}
	
	private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
	
	private Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
	
}
