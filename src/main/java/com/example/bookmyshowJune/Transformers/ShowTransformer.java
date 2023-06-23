package com.example.bookmyshowJune.Transformers;

import com.example.bookmyshowJune.Dtos.RequestDto.AddShowDto;
import com.example.bookmyshowJune.Models.Show;

public class ShowTransformer {

    public static Show convertDtoToEntity(AddShowDto addShowDto){

        Show show = Show.builder().time(addShowDto.getShowStartTime())
                .date(addShowDto.getShowDate()).build();

        return show;

    }
}
