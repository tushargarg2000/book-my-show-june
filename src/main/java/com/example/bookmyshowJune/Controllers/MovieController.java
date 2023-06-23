package com.example.bookmyshowJune.Controllers;


import com.example.bookmyshowJune.Dtos.RequestDto.MovieEntryDto;
import com.example.bookmyshowJune.Services.MovieService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public String addMovie(@RequestBody MovieEntryDto movieEntryDto){
        return movieService.addMovie(movieEntryDto);
    }


}
