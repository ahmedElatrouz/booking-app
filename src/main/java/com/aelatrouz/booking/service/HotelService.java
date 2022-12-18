package com.aelatrouz.booking.service;

import com.aelatrouz.booking.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> findAll();
    Hotel findById(Long id);
    Hotel save(Hotel hotel);
    void delete(Hotel hotel);
}
