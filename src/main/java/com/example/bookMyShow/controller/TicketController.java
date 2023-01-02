package com.example.bookMyShow.controller;

import com.example.bookMyShow.dto.requestDto.BookTicketRequestDto;
import com.example.bookMyShow.dto.responseDto.TicketResponseDto;
import com.example.bookMyShow.service.implementation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/add")
    public TicketResponseDto bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto){
        return ticketService.bookTicket(bookTicketRequestDto);
    }

    @GetMapping("/get/{id}")
    public TicketResponseDto getTicket(@PathVariable int id){
        return ticketService.getTicket(id);
    }
}
