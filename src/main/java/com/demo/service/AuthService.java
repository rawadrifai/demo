package com.demo.service;

import com.demo.domain.UserEntity;
import com.demo.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by rawad.elrifai on 12/22/16.
 */
@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public UserEntity registerUser(SignupRequest signupRequest) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(signupRequest.getEmail());
        userEntity.setFirstName(signupRequest.getFirstName());
        userEntity.setLastName(signupRequest.getLastName());
        userEntity.setSalt(Long.toString(System.currentTimeMillis()));

        // password stored will be password + salt
        String clearPasswordAndSalt = signupRequest.getPassword() + userEntity.getSalt();

        // hash password + salt
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(clearPasswordAndSalt.getBytes("UTF-8")); // Change this to "UTF-16" if needed
        byte[] digest = md.digest();

        userEntity.setPassword(new String(digest));

        return userRepository.save(userEntity);


    }
}
