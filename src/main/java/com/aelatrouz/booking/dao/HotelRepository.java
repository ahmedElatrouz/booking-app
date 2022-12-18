package com.aelatrouz.booking.dao;

import com.aelatrouz.booking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Optional custom repository methods go here
}
