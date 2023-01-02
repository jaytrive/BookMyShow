package com.example.bookMyShow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String allottedSeat;
    private int amount;
    private Date bookedOn;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    User user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Show show;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeats> showSeats;
}
