package com.example.springdatajpademo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springdatajpademo.services.JWTUtilService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JWTUtilService jwtUtilService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException{
		final String authorizationHeader= request.getHeader("Authorization");
		System.out.println(authorizationHeader);
		System.out.println("--------------");
		
		try {
			if(authorizationHeader.isBlank() || (authorizationHeader == null)) {
				throw new IOException("Token is not provided");
			
			}
			jwtUtilService.validateToken(authorizationHeader);
		}catch(Exception e) {
			throw new IOException(e.getMessage());
		}
		
		
		
		
		
		filterChain.doFilter(request, response);
		
	}

}
