package com.example.bookmyshowJune.Controllers;

import com.example.bookmyshowJune.Dtos.RequestDto.TicketRequestDto;
import com.example.bookmyshowJune.Dtos.ResponseDtos.TicketResponseDto;
import com.example.bookmyshowJune.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TicketResponseDto> bookTicket(@RequestBody TicketRequestDto ticketRequestDto){

        try{
            TicketResponseDto response =  ticketService.bookTicket(ticketRequestDto);
            response.setResponseMessage("Ticket booked successfully");

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            TicketResponseDto ticketResponseDto = new TicketResponseDto();
            ticketResponseDto.setResponseMessage(e.getMessage());
            return new ResponseEntity<>(ticketResponseDto,HttpStatus.BAD_REQUEST);
        }
    }

}
