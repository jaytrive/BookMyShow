package com.example.bookMyShow.dto.responseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MovieResponseDto {
    private int id;
    private String name;
    private LocalDate releasedate;
}
