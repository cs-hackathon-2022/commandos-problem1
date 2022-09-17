package com.cs.commandos.dto;

import com.cs.commandos.model.Employee;
import com.cs.commandos.model.Seat;

import java.sql.Timestamp;

public class BookingDto {
    private Seat seat;
    private Employee employee;
    private Timestamp fromDate;
    private Timestamp toDate;
}
