package com.example.bookMyShow.model;

import com.example.bookMyShow.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String city;
    private TheatreType theatreType;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Show> shows;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    List<TheatreSeat> theatreSeats;
}