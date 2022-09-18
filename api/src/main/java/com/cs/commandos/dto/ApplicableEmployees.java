package com.cs.commandos.dto;

import com.cs.commandos.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicableEmployees {
    private String fname;
    private String lname;
    private String roleCode;
}
