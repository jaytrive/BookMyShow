package com.example.bookMyShow.dto.requestDto;

import com.example.bookMyShow.dto.responseDto.MovieResponseDto;
import com.example.bookMyShow.dto.responseDto.TheatreResponseDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class Showdto {
    private LocalDate showdate;
    private LocalTime showtime;
    MovieResponseDto movieResponseDto;
    TheatreResponseDto theatreResponseDto;
}
