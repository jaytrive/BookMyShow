package com.example.bookMyShow.service.implementation;

import com.example.bookMyShow.converter.MovieConverter;
import com.example.bookMyShow.dto.requestDto.Moviedto;
import com.example.bookMyShow.dto.responseDto.MovieResponseDto;
import com.example.bookMyShow.model.Movie;
import com.example.bookMyShow.repository.MovieRepository;
import com.example.bookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    MovieResponseDto movieResponseDto;

    @Override
    public MovieResponseDto addMovie(Moviedto moviedto) {
        if(movieRepository.existsByName(moviedto.getName())){
            movieResponseDto.setName("Movie already exists");
            return  movieResponseDto;
        }
        Movie movie= MovieConverter.dtoToEntity(moviedto);
        movie=movieRepository.save(movie);
        movieResponseDto=MovieConverter.entityToDto(movie);
        return  movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        Movie movie=movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConverter.entityToDto(movie);
        return movieResponseDto;
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
