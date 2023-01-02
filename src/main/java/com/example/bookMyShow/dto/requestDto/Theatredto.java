package com.example.bookMyShow.dto.requestDto;

import com.example.bookMyShow.enums.TheatreType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theatredto {
    private String name;
    private String address;
    private String city;
    private TheatreType theatreType;
}
