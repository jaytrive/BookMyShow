package com.example.bookMyShow.model;

import com.example.bookMyShow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seat;
    private int rate;
    private SeatType type;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Theatre theatre;
}
