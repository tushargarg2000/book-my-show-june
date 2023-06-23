package com.example.bookmyshowJune.Controllers;

import com.example.bookmyshowJune.Dtos.RequestDto.TicketRequestDto;
import com.example.bookmyshowJune.Dtos.ResponseDtos.TicketResponseDto;
import com.example.bookmyshowJune.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/book-ticket")
    public TicketResponseDto bookTicket(@RequestBody TicketRequestDto ticketRequestDto){

        try{
            return ticketService.bookTicket(ticketRequestDto);

        }catch (Exception e){
            return new TicketResponseDto();
        }
    }

}
