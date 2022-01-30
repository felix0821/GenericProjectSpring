package com.system.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN) // set status code "403"
public class AppNotAuthorizedException extends RuntimeException {

	private static final long serialVersionUID = -6868237732691630236L;

	public AppNotAuthorizedException(String message) {
        super(message);
    }
}
