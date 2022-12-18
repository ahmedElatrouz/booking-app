package com.aelatrouz.booking.dao;

import com.aelatrouz.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Optional custom repository methods go here
}
