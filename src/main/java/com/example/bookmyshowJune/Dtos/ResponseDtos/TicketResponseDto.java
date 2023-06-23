package com.example.bookmyshowJune.Dtos.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {

    private String responseMessage;

    private LocalTime showTime;
    private Date showDate;

    private String movieName;

    private String theaterName;

    private String bookedSeats;

    private String location;

    private int totalPrice;
}
