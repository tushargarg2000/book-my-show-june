package com.example.bookmyshowJune.Services;


import com.example.bookmyshowJune.Dtos.RequestDto.TicketRequestDto;
import com.example.bookmyshowJune.Dtos.ResponseDtos.TicketResponseDto;
import com.example.bookmyshowJune.Exception.NoUserFoundException;
import com.example.bookmyshowJune.Exception.ShowNotFound;
import com.example.bookmyshowJune.Models.Show;
import com.example.bookmyshowJune.Models.ShowSeat;
import com.example.bookmyshowJune.Models.Ticket;
import com.example.bookmyshowJune.Models.User;
import com.example.bookmyshowJune.Repository.ShowRepository;
import com.example.bookmyshowJune.Repository.TicketRepository;
import com.example.bookmyshowJune.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private ShowRepository showRepository;

        @Autowired
        private TicketRepository ticketRepository;

        public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto)throws NoUserFoundException, ShowNotFound,Exception {

                //User validation
                int userId = ticketRequestDto.getUserId();
                Optional<User> userOptional = userRepository.findById(userId);
                if(!userOptional.isPresent()){
                        throw new NoUserFoundException("User Id is incorrect");
                }

                //Show Validation
                int showId = ticketRequestDto.getShowId();
                Optional<Show> showOptional = showRepository.findById(showId);
                if(!showOptional.isPresent()){
                        throw new ShowNotFound("Show is not found");
                }
                Show show = showOptional.get();

                //Validation for the requested Seats are available or not
                boolean isValid = validateShowAvailability(show,ticketRequestDto.getRequestedSeats());

                if(isValid==false){
                        throw new Exception("Requested Seats entered are not available");
                }

                Ticket ticket = new Ticket();
                //calculate the total price

                int totalPrice = calculateTotalPrice(show,ticketRequestDto.getRequestedSeats());

                ticket.setTotalTicketsPrice(totalPrice);

                //Convert the list of booked seats into string from list
                String bookedSeats = convertListToString(ticketRequestDto.getRequestedSeats());

                ticket.setBookedSeats(bookedSeats);
                //Do bidirectional mapping

                User user = userOptional.get();

                ticket = ticketRepository.save(ticket);

                user.getTicketList().add(ticket);
                //Saving the relevant repositories

                userRepository.save(user);

                show.getTicketList().add(ticket);

                showRepository.save(show);



                return createTicketReponseDto(show,ticket);
        }

        private boolean validateShowAvailability(Show show, List<String> requestedSeats){

                List<ShowSeat> showSeatList = show.getShowSeatList();

                for(ShowSeat showSeat : showSeatList){
                        String seatNo = showSeat.getSeatNo();
                        if(requestedSeats.contains(seatNo)){

                                if(showSeat.isAvailable()==false)
                                        return false;
                        }
                }
                return true;

        }

        private int calculateTotalPrice(Show show, List<String> requestedSeats){

                int totalPrice = 0;

                List<ShowSeat> showSeatList = show.getShowSeatList();

                for(ShowSeat showSeat : showSeatList){

                        if(requestedSeats.contains(showSeat.getSeatNo())){
                                totalPrice = totalPrice + showSeat.getPrice();
                                showSeat.setAvailable(false);
                        }
                }

                return totalPrice;
        }

        String convertListToString(List<String> seats){

                String result = "";
                for(String seatNo : seats){
                        result = result + seatNo+", ";
                }
                return result;
        }

        private TicketResponseDto createTicketReponseDto(Show show,Ticket ticket){

                TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                        .bookedSeats(ticket.getBookedSeats())
                        .location(show.getTheater().getLocation())
                        .theaterName(show.getTheater().getName())
                        .movieName(show.getMovie().getMovieName())
                        .showDate(show.getDate())
                        .showTime(show.getTime())
                        .build();

                return ticketResponseDto;
        }
}
