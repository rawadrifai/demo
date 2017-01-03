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
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/find/{firstName}", method = RequestMethod.GET)
    public List<User> getAllUsers(@PathVariable (value = "firstName") String firstName, HttpServletRequest httpServletRequest) throws Exception {

        LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );
        return userService.findByFirstName(firstName);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findbyid/{userId}", method = RequestMethod.GET)
    public User findUserById(@PathVariable (value = "userId") Integer userId, HttpServletRequest httpServletRequest) throws Exception {

        LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );
        return userService.findByUserId(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getaddresses", method = RequestMethod.GET)
    public List getNames(HttpServletRequest httpServletRequest) throws Exception {

        LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );
        return userService.getAddresses();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody SignupRequest signupRequest, HttpServletRequest httpServletRequest) throws Exception {

        LOG.info("Received request: {} - {}?{}", httpServletRequest.getProtocol(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString() );

        //User user = profileService.registerUser(signupRequest);
        //return user.getUserId() != null ? ResponseEntity.ok().body(user) : ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        return ResponseEntity.ok().build();
    }

}
