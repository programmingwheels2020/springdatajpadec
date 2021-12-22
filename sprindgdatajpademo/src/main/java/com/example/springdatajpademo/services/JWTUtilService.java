package com.example.springdatajpademo.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTUtilService {
	
	private String SECRET_KEY="ThisIsMySecret";
	
	
	
	public void decodeJWT(String token) {
		Claims claims = Jwts.parser()         
			       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
			       .parseClaimsJws(token).getBody();
	}
	

	public String createToken(Map<String,Object> claims, String subject) {
		return Jwts.builder().setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis()+(1000*60*60*10)))
				.setSubject(subject).signWith(SignatureAlgorithm.HS256,SECRET_KEY ).compact();
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		claims.put("userId", userDetails.getUsername());
		return this.createToken(claims, userDetails.getUsername());
	}
	
	public boolean validateToken(String token) {
		Claims claims = Jwts.parser()         
			       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
			       .parseClaimsJws(token).getBody();
		
		System.out.println(claims.getSubject());
		System.out.println(claims.getExpiration());
		
		return true;
	}
}
