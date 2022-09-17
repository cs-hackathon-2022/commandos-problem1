package com.cs.commandos.controller;

import com.cs.commandos.model.Booking;
import com.cs.commandos.service.BookingHistoryService;
import com.cs.commandos.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BookingHistoryContoller {

    @Autowired
    private BookingHistoryService bookingHistoryService;

    @GetMapping("/booking-history")
    public List<Booking> getBookingHistory() {
        return bookingHistoryService.getBookings();
    }

}
