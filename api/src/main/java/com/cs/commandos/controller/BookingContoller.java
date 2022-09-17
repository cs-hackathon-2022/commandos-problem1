package com.cs.commandos.controller;

import com.cs.commandos.model.Booking;
import com.cs.commandos.model.User;
import com.cs.commandos.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BookingContoller {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/booking")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

    @PostMapping("/booking")
    public void createBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
    }

    @DeleteMapping(path = { "/booking/{id}" })
    public Booking deleteBooking(@PathVariable("id") long id) {
        Booking booking = bookingService.deleteBooking(id);
        return booking;
    }
}
