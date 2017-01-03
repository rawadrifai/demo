package com.demo.repository;

import com.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rawad.elrifai on 12/22/16.
 */

@SuppressWarnings("JpaQlInspection")
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User users);
    List<User> findByFirstName(String firstName);
    List<User> findByFirstNameOrLastName(String firstName, String lastName);



    @Query(value = "SELECT u from User u where u.userId=:userId")
    User customSearchByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT a.street, a.city from Address a")
    List getAddresses();

}
