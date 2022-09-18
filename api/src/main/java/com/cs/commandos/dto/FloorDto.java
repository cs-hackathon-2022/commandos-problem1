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
public class FloorDto {
    private String floorName;
    private Boolean isAvailable;
    private int count;
    private List<ZoneDto> zoneDtoList;
}
