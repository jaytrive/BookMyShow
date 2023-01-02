package com.example.bookMyShow.converter;

import com.example.bookMyShow.dto.requestDto.Theatredto;
import com.example.bookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.bookMyShow.model.Theatre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static Theatre dtoToEntity(Theatredto theatredto){
        return Theatre.builder().city(theatredto.getCity()).address(theatredto.getAddress()).name(theatredto.getName()).theatreType(theatredto.getTheatreType()).build();
    }

    public static TheatreResponseDto entityToDto(Theatre theatre){
        return TheatreResponseDto.builder().id(theatre.getId()).name(theatre.getName()).address(theatre.getAddress()).city(theatre.getCity()).theatreType(theatre.getTheatreType()).build();
    }
}
