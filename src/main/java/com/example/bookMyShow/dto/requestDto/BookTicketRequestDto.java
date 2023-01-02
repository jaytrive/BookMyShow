package com.example.bookMyShow.dto.requestDto;

import com.example.bookMyShow.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {
    private int userId;
    private int showId;
    private SeatType seatType;
    private Set<String> requestedSeats;
}
