package com.example.bookMyShow.dto.responseDto;

import com.example.bookMyShow.enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDto {
    private int id;
    private String name;
    private String address;
    private String city;
    private TheatreType theatreType;
}
