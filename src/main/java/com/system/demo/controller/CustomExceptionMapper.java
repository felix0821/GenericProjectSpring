package com.system.demo.controller;

import com.system.demo.dto.ErrorDto;
import com.system.demo.exception.AppBadRequestException;
import com.system.demo.exception.AppNotAuthorizedException;
import com.system.demo.exception.AppNotFoundException;

import io.jsonwebtoken.MalformedJwtException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static com.system.demo.dto.ErrorDto.DetailError;

@RestControllerAdvice
public class CustomExceptionMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception,
                                                                     WebRequest request) {
        List<DetailError> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String msg = violation.getRootBeanClass().getSimpleName() + " " + violation.getPropertyPath() + ": "
                    + violation.getMessage() + " [current value = " + violation.getInvalidValue() + "]";

            errors.add(new DetailError(msg));
        }

        ErrorDto apiError = new ErrorDto(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), request,
                errors.toArray(new DetailError[0]));

        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = { MalformedJwtException.class, InsufficientAuthenticationException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		    String bodyOfResponse = "This should be application specific";
		    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

    @ExceptionHandler
    public ResponseEntity<Object> handleWrappedConstraintViolationException(TransactionSystemException exception,
                                                                            WebRequest request) throws Exception {
        if (exception.getRootCause() instanceof ConstraintViolationException) {
            ConstraintViolationException constraintException = (ConstraintViolationException) exception.getRootCause();
            return handleConstraintViolationException(constraintException, request);
        } else {
            return handleException(exception, request);
        }
    }

    /**
     * Here we have to override implementation of ResponseEntityExceptionHandler.
     */
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                               HttpHeaders headers, HttpStatus status, WebRequest request) {
        return convertToResponseEntity(exception, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleBadRequestException(AppBadRequestException exception, WebRequest request) {
        return convertToResponseEntity(exception, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleNotFoundException(AppNotFoundException exception, WebRequest request) {
        return convertToResponseEntity(exception, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleNotAuthorizedException(AppNotAuthorizedException exception, WebRequest request) {
        return convertToResponseEntity(exception, HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleNotAuthorizedException(AccessDeniedException exception, WebRequest request) {
        return convertToResponseEntity(exception, HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleAll(Exception exception, WebRequest request) {
        return convertToResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ResponseEntity<Object> convertToResponseEntity(Exception exception, HttpStatus status, WebRequest request) {
        ErrorDto apiError = new ErrorDto(status, exception.getLocalizedMessage(), request,
                new DetailError(exception.getClass().getSimpleName() + ": error occurred"));

        return new ResponseEntity<>(apiError, new HttpHeaders(), status);
    }

}
