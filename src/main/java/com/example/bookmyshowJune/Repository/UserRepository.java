package com.example.bookmyshowJune.Repository;

import com.example.bookmyshowJune.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from users where age >= :value",nativeQuery = true)
    List<User> findUserWithAgeGreater(Integer value);
    //This is a custom function that you have defined
    //You need to write a query on top of this

}
