package com.example.bookmyshowJune.Models;


import com.example.bookmyshowJune.Enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "theater_seats")
@Data
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String seatNo; //1A , 2B

    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;

}
