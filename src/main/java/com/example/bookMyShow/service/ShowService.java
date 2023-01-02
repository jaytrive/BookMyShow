package com.example.bookMyShow.service;

import com.example.bookMyShow.dto.requestDto.Showdto;
import com.example.bookMyShow.dto.responseDto.ShowResponseDto;

public interface ShowService {

    public ShowResponseDto addShow(Showdto showdto);

    public ShowResponseDto getShow(int id);
}
