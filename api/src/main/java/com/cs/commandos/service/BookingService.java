package com.cs.commandos.service;

import com.cs.commandos.model.Booking;
import com.cs.commandos.model.User;
import com.cs.commandos.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }


    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking deleteBooking(long id) {
        Booking booking = bookingRepository.getOne(id);
        bookingRepository.deleteById(id);
        return booking;
    }

}

