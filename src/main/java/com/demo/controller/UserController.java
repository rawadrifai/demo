package com.demo.controller;


import com.demo.domain.User;
import com.demo.request.SignupRequest;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by rawad.elrifai on 5/3/16.
 */
@RestController
@RequestMapping("/search")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public List<User> getAllUsers() throws Exception {
        LOG.info("hello");
       // LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );
        return userService.getAllUsers();
        //return ResponseEntity.ok().body(userService.getAllUsers());

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/updateemail", method = RequestMethod.PUT)
    public ResponseEntity updateEmail(@RequestBody SignupRequest signupRequest, HttpServletRequest httpServletRequest) throws Exception {

        LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );

        //User user = profileService.registerUser(signupRequest);
        //return user.getUserId() != null ? ResponseEntity.ok().body(user) : ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        return ResponseEntity.ok().build();
    }

}
