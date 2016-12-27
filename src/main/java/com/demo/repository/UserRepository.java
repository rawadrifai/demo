package com.demo.repository;

import com.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rawad.elrifai on 12/22/16.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User user);

    ///  List<User> findByEmailAndPassword(String email);
    List<User> findAll();

}
