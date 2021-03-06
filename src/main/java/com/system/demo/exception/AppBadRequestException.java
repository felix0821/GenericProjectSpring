package com.system.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AppBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 8629751981495963452L;

	public AppBadRequestException(String message) {
        super(message);
    }

    public AppBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}