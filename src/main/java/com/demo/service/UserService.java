package com.demo.service;

import com.demo.domain.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by rawad.elrifai on 12/22/16.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
    public User findByUserId(Integer userId) {return userRepository.customSearchByUserId(userId); }
    public List getAddresses() {return userRepository.getAddresses(); }

}
