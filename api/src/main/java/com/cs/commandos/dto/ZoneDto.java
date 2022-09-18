package com.cs.commandos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZoneDto {
    private String zoneName;
    private int numberOfSeats;
    private List<SpaceMiniDto> reservedSeats;
    private List<SpaceMiniDto> availableSeats;
    private int rangeTo;
    private int availableSeatCount;
}
