package com.cs.commandos.dto;

import com.cs.commandos.model.Employee;
import com.cs.commandos.model.Zone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SpaceOwnerDto {
    private Long seatStart;
    private Long seatEnd;
    private Long empId;
    private String zone;
}
