package com.example.bookMyShow.converter;

import com.example.bookMyShow.dto.requestDto.Showdto;
import com.example.bookMyShow.dto.responseDto.ShowResponseDto;
import com.example.bookMyShow.model.Show;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public static Show dtoToEntity(Showdto showdto) {
        return Show.builder().show_date(showdto.getShowdate()).show_time(showdto.getShowtime()).build();
    }

    public static ShowResponseDto entityToDto(Show show, Showdto showdto) {
        return ShowResponseDto.builder().id(show.getId()).showdate(show.getShow_date()).showtime(show.getShow_time()).movieResponseDto(showdto.getMovieResponseDto()).theatreResponseDto(showdto.getTheatreResponseDto()).build();
    }

    public static ShowResponseDto entityToDto(Show show) {
        return ShowResponseDto.builder().id(show.getId()).showtime(show.getShow_time()).showdate(show.getShow_date()).build();
    }
}
