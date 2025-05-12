package com.francisco.library_management.auth.infraestructure.security.jwt;

import io.jsonwebtoken.security.SignatureException;

import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.infraestructure.configuration.JwtProperties;
import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.TokenModifiedException;
import com.francisco.library_management.auth.infraestructure.security.UserReaderForConfiguration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtTokenValidator {

	private String key;
	private SecretKey secretKey;
	
	private UserReaderForConfiguration userReaderForConfiguration;
	
	public JwtTokenValidator(UserReaderForConfiguration userReaderForConfiguration,
			JwtProperties jwtProperties) {
		this.userReaderForConfiguration = userReaderForConfiguration;
		key = jwtProperties.getKey();
	}
	
	@PostConstruct
	public void init() {
		byte[] keyByte = Decoders.BASE64.decode(key);
		secretKey = Keys.hmacShaKeyFor(keyByte);
	}
	
	public boolean isTokenValid(String token) throws TokenModifiedException {
			final String username = extractUsername(token);
			
			final UserDetails userDetails = userReaderForConfiguration.findUserDetailsImpl(username);
			
			return userDetails != null
					&&
					!isTokenExpired(token);
	}
	
	public String extractUsername(String token) throws TokenModifiedException {
		return extractClaims(token).getSubject();
	}
	
	private boolean isTokenExpired(String token) throws TokenModifiedException {
        return extractClaims(token).getExpiration().before(new Date());
    }
	
	private Claims extractClaims(String token) throws TokenModifiedException {
        try {
        	return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch(SignatureException signatureException) {
        	throw new TokenModifiedException();
        }
    }
	
}
