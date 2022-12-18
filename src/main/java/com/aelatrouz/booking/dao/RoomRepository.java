package com.aelatrouz.booking.dao;

import com.aelatrouz.booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    // Optional custom repository methods go here
}