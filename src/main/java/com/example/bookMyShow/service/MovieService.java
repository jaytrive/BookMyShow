package com.example.bookMyShow.service;

import com.example.bookMyShow.dto.requestDto.Moviedto;
import com.example.bookMyShow.dto.responseDto.MovieResponseDto;

public interface MovieService {

    public MovieResponseDto addMovie(Moviedto moviedto);

    public MovieResponseDto getMovie(int id);

    public void deleteMovie(int id);
}
