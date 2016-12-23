package com.demo.controller;

import com.demo.exception.UnauthorizedLoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        LOG.info(ex.getMessage());
        LOG.info(
                "request.getAuthType(): " + request.getAuthType()
                        + "request.getAuthType(): " + request.getAuthType()
                        + "request.getContextPath(): " + request.getContextPath()
                        + "request.getMethod(): " + request.getMethod()
                        + "request.getPathInfo(): " + request.getPathInfo()
                        + "request.getPathTranslated(): " + request.getPathTranslated()
                        + "request.getQueryString(): " + request.getQueryString()
                        + "request.getRemoteUser(): " + request.getRemoteUser()
                        + "request.getProtocol(): " + request.getProtocol()
                        + "request.getServerPort(): " + request.getServerPort()
                        + "request.getRequestURI(): " + request.getRequestURI()
        );

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {

        LOG.info("exception caught: " + ex.getMessage());
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
