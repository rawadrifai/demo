package com.demo.controller;


import com.demo.domain.UserEntity;
import com.demo.exception.UnauthorizedLoginException;
import com.demo.request.SignupRequest;
import com.demo.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;


/**
 * Created by rawad.elrifai on 5/3/16.
 */
@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    AuthService authService;

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> login(@RequestHeader Map<String, String> requestHeaders, HttpServletRequest httpServletRequest) throws Exception {

        LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );

        String username = requestHeaders.get("username");
        String password = requestHeaders.get("password");

        if (username.equals("user") && password.equals("password")) {

            MultiValueMap<String, String> responseHeaders = new LinkedMultiValueMap<>();
            responseHeaders.set("authenticated", "true");

            return new ResponseEntity<String>(new LinkedMultiValueMap<String, String>(responseHeaders), HttpStatus.ACCEPTED);

        } else {
            throw new UnauthorizedLoginException();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/signup", method = RequestMethod.PUT)
    public ResponseEntity signup(@RequestBody SignupRequest signupRequest, HttpServletRequest httpServletRequest) throws Exception {

        LOG.info("test");
        LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );

        UserEntity userEntity = authService.registerUser(signupRequest);
        return userEntity.getId() != null ? ResponseEntity.ok().body(userEntity) : ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();

    }

}
