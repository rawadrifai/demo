package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by rawad.elrifai on 7/19/16.
 */

@SuppressWarnings({"unused", "FieldCanBeLocal"})
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedLoginException extends Exception {

    private static final String EXCEPTION_MESSAGE = "Incorrect username or password";

    public UnauthorizedLoginException() {
        super(EXCEPTION_MESSAGE);
    }

    public UnauthorizedLoginException(String message) {
        super(message);
    }
}
