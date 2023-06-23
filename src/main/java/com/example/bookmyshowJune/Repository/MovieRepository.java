package com.example.bookmyshowJune.Repository;

import com.example.bookmyshowJune.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
