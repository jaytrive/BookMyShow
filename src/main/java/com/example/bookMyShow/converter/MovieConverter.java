package com.example.bookMyShow.converter;

import com.example.bookMyShow.dto.requestDto.Moviedto;
import com.example.bookMyShow.dto.responseDto.MovieResponseDto;
import com.example.bookMyShow.model.Movie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static Movie dtoToEntity(Moviedto moviedto){
        return Movie.builder().name(moviedto.getName()).release_date(moviedto.getRelease_date()).build();
    }

    public static MovieResponseDto entityToDto(Movie movie){
        return MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).releasedate(movie.getRelease_date()).build();
    }
}
