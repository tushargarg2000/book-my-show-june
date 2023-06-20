package com.example.bookmyshowJune.Transformers;

import com.example.bookmyshowJune.Dtos.RequestDto.TheaterEntryDto;
import com.example.bookmyshowJune.Models.Theater;

public class TheaterTransformers {

    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        Theater theater = Theater.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();

        return theater;
    }

}
