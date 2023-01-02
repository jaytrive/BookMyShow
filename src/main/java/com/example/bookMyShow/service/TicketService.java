package com.example.bookMyShow.service;

import com.example.bookMyShow.dto.requestDto.BookTicketRequestDto;
import com.example.bookMyShow.dto.responseDto.TicketResponseDto;

public interface TicketService {

    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    public TicketResponseDto getTicket(int id);
}
