package com.system.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = -547025560516160617L;

	public AppNotFoundException(String message) {
        super(message);
    }
}