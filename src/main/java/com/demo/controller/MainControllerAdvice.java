package com.demo.controller;

import com.demo.exception.UnauthorizedLoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rawad.elrifai on 7/19/16.
 */
@RestControllerAdvice
public class MainControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @ExceptionHandler(UnauthorizedLoginException.class)
    public ResponseEntity<String> handleUnauthorizedLoginException(HttpServletRequest request, Exception ex) {

        logRequestInfoAndException(request, ex);
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(HttpServletRequest request, Exception ex) {

        logRequestInfoAndException(request, ex);
        return new ResponseEntity<String>("Record already exists", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(HttpServletRequest request, Exception ex) {

        logRequestInfoAndException(request, ex);
        return new ResponseEntity<String>("Report this exception: " + ex.getClass() + " - " + ex.getMessage(), HttpStatus.NO_CONTENT);
    }

    private void logRequestInfoAndException(HttpServletRequest request, Exception ex) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ex.getClass().toString()).append("-").append(ex.getMessage());
        LOG.info(stringBuffer.toString());
    }
}
