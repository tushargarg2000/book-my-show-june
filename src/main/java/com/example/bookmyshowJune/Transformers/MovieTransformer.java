package com.example.bookmyshowJune.Transformers;

import com.example.bookmyshowJune.Dtos.RequestDto.MovieEntryDto;
import com.example.bookmyshowJune.Models.Movie;

public class MovieTransformer {

    public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){

        Movie movie = Movie.builder().movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .rating(movieEntryDto.getRating()).releaseDate(movieEntryDto.getReleaseDate())
                .build();

        return movie;
    }
}
