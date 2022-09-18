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
public class EmployeeApplicableSpaceDto {
    private List<SpaceMiniDto> availableSeats;
    private List<SpaceMiniDto> reservedSeats;
}

/*


    {
        availableSeats: [ {} ],
        allocatedSeats: [ {} ],
        allSeats: [ {} ],
    }

 */