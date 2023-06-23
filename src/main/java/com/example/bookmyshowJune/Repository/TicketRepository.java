package com.example.bookmyshowJune.Repository;

import com.example.bookmyshowJune.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
