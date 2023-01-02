package com.example.bookMyShow.service.implementation;

import com.example.bookMyShow.converter.ShowConverter;
import com.example.bookMyShow.dto.requestDto.Showdto;
import com.example.bookMyShow.dto.responseDto.ShowResponseDto;
import com.example.bookMyShow.model.*;
import com.example.bookMyShow.repository.MovieRepository;
import com.example.bookMyShow.repository.ShowRepository;
import com.example.bookMyShow.repository.ShowseatsRepository;
import com.example.bookMyShow.repository.TheatreRepository;
import com.example.bookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowseatsRepository showseatsRepository;

    @Override
    public ShowResponseDto addShow(Showdto showdto) {
        Show show= ShowConverter.dtoToEntity(showdto);
        Movie movie=movieRepository.findById(showdto.getMovieResponseDto().getId()).get();
        Theatre theatre=theatreRepository.findById(showdto.getTheatreResponseDto().getId()).get();
        show.setMovie(movie);
        show.setTheatre(theatre);
        show=showRepository.save(show);
        List<ShowSeats> showSeats=createShowSeats(theatre.getTheatreSeats(),show);
        showseatsRepository.saveAll(showSeats);
        ShowResponseDto showResponseDto=ShowConverter.entityToDto(show,showdto);
        return showResponseDto;
    }

    private List<ShowSeats> createShowSeats(List<TheatreSeat> theatreSeats, Show show) {
        List<ShowSeats> showSeats=new ArrayList<>();
        for(TheatreSeat theatreSeat:theatreSeats){
            ShowSeats seats=ShowSeats.builder().seat_no(theatreSeat.getSeat()).rate(theatreSeat.getRate()).seattype(theatreSeat.getType()).build();
            showSeats.add(seats);
        }
        for(ShowSeats seats:showSeats){
            seats.setShow(show);
        }
        show.setShowSeats(showSeats);
        return showSeats;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        Show show=showRepository.findById(id).get();
        return ShowConverter.entityToDto(show);
    }
}
