package com.example.bookMyShow.dto.requestDto;

import com.example.bookMyShow.dto.responseDto.ShowResponseDto;
import com.example.bookMyShow.dto.responseDto.UserResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TicketDto {
    private String allottedSeat;
    private int amount;
    private Date bookedOn;
    UserResponseDto userResponseDto;
    ShowResponseDto showResponseDto;
}
