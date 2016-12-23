package com.demo.service;

import com.demo.domain.UserEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rawad.elrifai on 12/22/16.
 */

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findByEmail(String email);
    List<UserEntity> findAll();

}
