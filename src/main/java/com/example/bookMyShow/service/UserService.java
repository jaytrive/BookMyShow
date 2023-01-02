package com.example.bookMyShow.service;

import com.example.bookMyShow.dto.requestDto.Userdto;
import com.example.bookMyShow.dto.responseDto.UserResponseDto;

public interface UserService {

    public void addUser(Userdto userdto);

    public UserResponseDto getUser(int id);
}
