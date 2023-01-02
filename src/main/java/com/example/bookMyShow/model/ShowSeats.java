package com.example.bookMyShow.model;

import com.example.bookMyShow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String seat_no;
    private boolean booked;
    private Date bookedDate;
    private SeatType seattype;

    @ManyToOne
    @JsonIgnore
    Ticket ticket;

    @ManyToOne
    @JsonIgnore
    Show show;
}
