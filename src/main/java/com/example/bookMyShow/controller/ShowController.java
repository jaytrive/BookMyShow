package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.requestDto.Showdto;
import com.example.bookMyShow.dto.responseDto.ShowResponseDto;
import com.example.bookMyShow.service.implementation.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody Showdto showdto){
        return showService.addShow(showdto);
    }

    @GetMapping("/get/{id}")
    public ShowResponseDto getShow(@PathVariable int id){
        return showService.getShow(id);
    }
}
