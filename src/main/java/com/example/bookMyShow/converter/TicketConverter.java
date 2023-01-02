package com.example.bookMyShow.converter;

import com.example.bookMyShow.dto.responseDto.TicketResponseDto;
import com.example.bookMyShow.model.Ticket;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    public static TicketResponseDto entityToDto(Ticket ticket) {
        return TicketResponseDto.builder().id(ticket.getId()).allottedSeat(ticket.getAllottedSeat()).amount(ticket.getAmount()).build();
    }
}
