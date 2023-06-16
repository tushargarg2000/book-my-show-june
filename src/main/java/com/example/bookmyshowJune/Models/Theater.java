package com.example.bookmyshowJune.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;


    //Keeping in mind the parent class
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();


}
