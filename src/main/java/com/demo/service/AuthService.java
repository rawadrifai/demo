package com.demo.service;

import com.demo.domain.Address;
import com.demo.domain.User;
import com.demo.repository.UserRepository;
import com.demo.request.SignupRequest;
import org.springframework.aop.framework.ProxyFactoryBean;
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

    public User registerUser(SignupRequest signupRequest) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        User user = new User();
        user.setUserId(signupRequest.getUserId());
        user.setEmail(signupRequest.getEmail());
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setSalt(Long.toString(System.currentTimeMillis()));

        user.setAddresses(signupRequest.getAddresses());

        for (Address address:user.getAddresses()) {
            address.setUser(user);
        }

        // password stored will be password + salt
        String clearPasswordAndSalt = signupRequest.getPassword() + user.getSalt();

        // hash password + salt
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(clearPasswordAndSalt.getBytes("UTF-8")); // Change this to "UTF-16" if needed
        byte[] digest = md.digest();

      //  user.setPassword(new String(digest));
        user.setPassword(signupRequest.getPassword());
        return userRepository.save(user);


    }
}
