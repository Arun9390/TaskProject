package com.firstproject.taskproject.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.firstproject.taskproject.exception.APIException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
	//private final String jwtSecret = System.getenv("JWT_SECRET_KEY");
	public String generateToken(Authentication authentication) {
		
		String email = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime()+3600000);
		
		String token = Jwts.builder()
				.setSubject(email)
				.setIssuedAt(currentDate)
				.setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512,"JWTSecretKey")
				.compact();
		
		
		return token;
	}
	public String getEmailFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey("JWTSecretKey")
				.parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}
	public boolean validationToken(String token) {
		try {
			Jwts.parser().setSigningKey("JWTSecretKey")
			.parseClaimsJws(token);
			return true;
		}
		catch(Exception e) {
			throw new APIException("Token issue :"+e.getMessage());
		}
	}

}
