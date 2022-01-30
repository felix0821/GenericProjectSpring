package com.system.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
	
	@Autowired
    JwtProvider jwtProvider;
	
	public String usernameFromToken(HttpHeaders headers) {
		final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
		String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		String usernameFromToken = jwtProvider.getUsernameFromToken(token);
		return usernameFromToken;
	}

}
