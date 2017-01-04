package com.demo.service;

import com.demo.domain.User;
import com.demo.exception.UserNotFoundException;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
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
    public List<User> findByFirstNameOrLastName(String firstName, String lastName) throws UserNotFoundException {

        List<User> foundUsers = userRepository.findByFirstNameOrLastName(firstName, lastName);

        if (foundUsers.size() < 1)
            throw new UserNotFoundException();

        return foundUsers;
    }
    public User findByUserId(Integer userId) {return userRepository.customSearchByUserId(userId); }
    public List getAddresses() {return userRepository.getAddresses(); }

    public List<User> findByCreated(Instant created) {
        return userRepository.customFindByCreated(created.toString());
    }

}
