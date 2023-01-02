package com.example.bookMyShow.dto.requestDto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Moviedto {
    private String name;
    private LocalDate release_date;
}
