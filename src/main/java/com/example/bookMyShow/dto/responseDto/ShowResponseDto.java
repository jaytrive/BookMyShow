package com.example.bookMyShow.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponseDto {
    private int id;
    private LocalDate showdate;
    private LocalTime showtime;
    MovieResponseDto movieResponseDto;
    TheatreResponseDto theatreResponseDto;
}
