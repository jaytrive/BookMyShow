package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.requestDto.Userdto;
import com.example.bookMyShow.dto.responseDto.UserResponseDto;
import com.example.bookMyShow.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Userdto userdto){
        userService.addUser(userdto);
        return new ResponseEntity("User added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public UserResponseDto getUser(@PathVariable int id){
        return userService.getUser(id);
    }
}
