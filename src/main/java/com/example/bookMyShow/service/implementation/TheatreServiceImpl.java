package com.example.bookMyShow.service.implementation;

import com.example.bookMyShow.converter.TheatreConverter;
import com.example.bookMyShow.dto.requestDto.Theatredto;
import com.example.bookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.bookMyShow.enums.SeatType;
import com.example.bookMyShow.model.Theatre;
import com.example.bookMyShow.model.TheatreSeat;
import com.example.bookMyShow.repository.TheatreRepository;
import com.example.bookMyShow.repository.TheatreseatsRepository;
import com.example.bookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreseatsRepository theatreseatsRepository;

    @Override
    public TheatreResponseDto addTheatre(Theatredto theatredto) {
        Theatre theatre= TheatreConverter.dtoToEntity(theatredto);
        List<TheatreSeat> seats= createseats();
        theatre.setTheatreSeats(seats);
        theatre.setShows(null);
        for(TheatreSeat theatreSeat:seats){
            theatreSeat.setTheatre(theatre);
        }
        theatre=theatreRepository.save(theatre);
        theatreseatsRepository.saveAll(seats);
        return TheatreConverter.entityToDto(theatre);
    }

    private List<TheatreSeat> createseats() {
        List<TheatreSeat> seats=new ArrayList<>();

        seats.add(getTheatreseat("A1",200, SeatType.GOLD));
        seats.add(getTheatreseat("A2",200, SeatType.GOLD));
        seats.add(getTheatreseat("A3",200, SeatType.GOLD));
        seats.add(getTheatreseat("A4",200, SeatType.GOLD));
        seats.add(getTheatreseat("A5",200, SeatType.GOLD));

        seats.add(getTheatreseat("D1",150, SeatType.SILVER));
        seats.add(getTheatreseat("D2",150, SeatType.SILVER));
        seats.add(getTheatreseat("D3",150, SeatType.SILVER));
        seats.add(getTheatreseat("D4",150, SeatType.SILVER));
        seats.add(getTheatreseat("D5",150, SeatType.SILVER));

        seats.add(getTheatreseat("AA",250, SeatType.SOFA));
        seats.add(getTheatreseat("BB",250, SeatType.SOFA));
        seats.add(getTheatreseat("CC",250, SeatType.SOFA));
        seats.add(getTheatreseat("DD",250, SeatType.SOFA));
        seats.add(getTheatreseat("EE",250, SeatType.SOFA));

        return seats;
    }

    private TheatreSeat getTheatreseat(String seat, int rate, SeatType type) {
        return TheatreSeat.builder().seat(seat).rate(rate).type(type).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id) {
        Theatre theatre=theatreRepository.findById(id).get();
        return TheatreConverter.entityToDto(theatre);
    }
}
