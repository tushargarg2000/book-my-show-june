package com.example.bookmyshowJune.Controllers;


import com.example.bookmyshowJune.Dtos.RequestDto.TheaterEntryDto;
import com.example.bookmyshowJune.Dtos.RequestDto.TheaterSeatsEntryDto;
import com.example.bookmyshowJune.Services.TheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterServices theaterServices;

    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto){

            return theaterServices.addTheater(theaterEntryDto);
    }

    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody TheaterSeatsEntryDto entryDto){

        return theaterServices.addTheaterSeats(entryDto);

    }

}
