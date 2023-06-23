package com.example.bookmyshowJune.Services;

import com.example.bookmyshowJune.Dtos.RequestDto.MovieEntryDto;
import com.example.bookmyshowJune.Models.Movie;
import com.example.bookmyshowJune.Repository.MovieRepository;
import com.example.bookmyshowJune.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto){

        Movie movie = MovieTransformer.convertDtoToEntity(movieEntryDto);

        movieRepository.save(movie);

        return "Movie added successfully";
    }

}
