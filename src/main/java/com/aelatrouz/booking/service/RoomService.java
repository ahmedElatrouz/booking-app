package com.aelatrouz.booking.service;

import com.aelatrouz.booking.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(Long id);
    Room save(Room room);
    void delete(Room room);
}
