package com.example.bookmyshowJune.Repository;

import com.example.bookmyshowJune.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {


    Theater findByLocation(String location);

}
