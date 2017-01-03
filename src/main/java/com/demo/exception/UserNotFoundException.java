package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by rawad.elrifai on 7/19/16.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal"})
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    private static final String EXCEPTION_MESSAGE = "user not found";

    public UserNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
