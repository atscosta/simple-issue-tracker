package com.alyssontiberio.sit.issue;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Resource not found! Make sure the description of item is correct.";

    public ResourceNotFoundException(){
        super(DEFAULT_MESSAGE);
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
