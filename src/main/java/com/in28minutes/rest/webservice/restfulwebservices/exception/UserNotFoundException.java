package com.in28minutes.rest.webservice.restfulwebservices.exception;

import com.sun.xml.internal.ws.api.model.CheckedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
