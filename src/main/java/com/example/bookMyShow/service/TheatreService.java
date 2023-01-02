package com.example.bookMyShow.service;

import com.example.bookMyShow.dto.requestDto.Theatredto;
import com.example.bookMyShow.dto.responseDto.TheatreResponseDto;

public interface TheatreService {

    public TheatreResponseDto addTheatre(Theatredto theatredto);

    public TheatreResponseDto getTheatre(int id);
}
