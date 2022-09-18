package com.cs.commandos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeApplicableSpaceDto {
    private List<SpaceMiniDto> availableSeats = new ArrayList<>();
    private List<SpaceMiniDto> reservedSeats = new ArrayList<>();
}

/*


    {
        availableSeats: [ {} ],
        allocatedSeats: [ {} ],
        allSeats: [ {} ],
    }

 */