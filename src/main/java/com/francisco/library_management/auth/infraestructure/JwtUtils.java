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
	
	private static final String SECRET_KEY = "szrMiFwEW0Oo/TljcAVCdAsod8GVJuevtOk9HnZHFgirBcs9ydnbDFysmusxdckRR8IIv4C6VUAptMD1UBgnqaQqUqXdYhAb5on3toq/i8KBEs8AEGhC/mmQYDmiLupa291oMfvacAP8RAJRqZzcBeG3O7J9j9WnLMOl4Q/Kiqbu6jQANDM+qWPammlSt0wxykdf3G+6ac9Z7BJhfMpS3HhPnb4vzAsU5EWBdwOvPa+1DWx8vAj9u4+OcI6fIur5Ti82f82VxHL3d32k9zlDF67ElYQ+wCNaMenWErfELn+xTZUZIXI/VoDG2UWmOezKxSnucRNxIrCrqOtv42R7";
	
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
