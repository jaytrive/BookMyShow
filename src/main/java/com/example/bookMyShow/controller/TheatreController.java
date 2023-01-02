package com.example.bookMyShow.controller;

import com.example.bookMyShow.converter.TheatreConverter;
import com.example.bookMyShow.dto.requestDto.Theatredto;
import com.example.bookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.bookMyShow.model.Theatre;
import com.example.bookMyShow.service.implementation.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("/add")
    public TheatreResponseDto addTheatre(@RequestBody Theatredto theatredto){
        return theatreService.addTheatre(theatredto);
    }

    @GetMapping("/get/{id}")
    public TheatreResponseDto getTheatre(@PathVariable int id) {
        return theatreService.getTheatre(id);
    }
}
