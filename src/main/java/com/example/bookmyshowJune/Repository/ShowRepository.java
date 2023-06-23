package com.example.bookmyshowJune.Repository;

import com.example.bookmyshowJune.Dtos.ResponseDtos.QueryResponseDto;
import com.example.bookmyshowJune.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ShowRepository extends JpaRepository<Show,Integer> {


    @Query(value = "select movie_id from shows group by movie_id order by count(*) desc limit 1;",nativeQuery = true)
    public Integer getMostShowedMovie(Date checkDate);
}

/*
    Find total collection (revenue) that a particular movie has made in its lifetime (across all theaters combined)
*/