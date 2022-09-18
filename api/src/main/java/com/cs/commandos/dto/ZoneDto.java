package com.cs.commandos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZoneDto {
    private String zoneName;
    private int numberOfSeats;
    private int rangeFrom;
    private int rangeTo;
    private int availableSeats;
}
