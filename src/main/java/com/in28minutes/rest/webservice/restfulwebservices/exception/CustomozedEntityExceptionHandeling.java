package com.in28minutes.rest.webservice.restfulwebservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomozedEntityExceptionHandeling extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){

        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){

        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),
                "Validation failed", ex.getBindingResult().toString());
        return new ResponseEntity(exceptionDetails, HttpStatus.BAD_REQUEST);
    }


}
