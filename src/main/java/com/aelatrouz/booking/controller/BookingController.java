package com.aelatrouz.booking.controller;

import com.aelatrouz.booking.entity.Booking;
import com.aelatrouz.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> findAll() {
        List<Booking> bookings = bookingService.findAll();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> save(@RequestBody @Validated Booking booking) {
        Booking savedBooking = bookingService.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        bookingService.delete(booking);
        return ResponseEntity.ok().build();
    }

}
