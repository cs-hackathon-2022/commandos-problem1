package com.cs.commandos.dto;

import com.cs.commandos.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicableEmployeeResponse {
    private List<ApplicableEmployees> applicableEmployees;
}
