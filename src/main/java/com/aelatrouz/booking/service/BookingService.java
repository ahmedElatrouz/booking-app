package com.aelatrouz.booking.service;

import com.aelatrouz.booking.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();
    Booking findById(Long id);
    Booking save(Booking booking);
    void delete(Booking booking);
}
