package com.example.bookMyShow.converter;

import com.example.bookMyShow.dto.requestDto.Userdto;
import com.example.bookMyShow.dto.responseDto.UserResponseDto;
import com.example.bookMyShow.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static User dtoToEntity(Userdto userdto){
        return User.builder().name(userdto.getName()).mobile(userdto.getMobile()).build();
    }

    public static UserResponseDto entityToDto(User user){
        return UserResponseDto.builder().id(user.getId()).name(user.getName()).mobile(user.getMobile()).build();
    }
}
