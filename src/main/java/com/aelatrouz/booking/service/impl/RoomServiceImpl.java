package com.aelatrouz.booking.service.impl;

import com.aelatrouz.booking.controller.dto.RoomDTO;
import com.aelatrouz.booking.dao.HotelRepository;
import com.aelatrouz.booking.dao.RoomRepository;
import com.aelatrouz.booking.entity.Hotel;
import com.aelatrouz.booking.entity.Room;
import com.aelatrouz.booking.enums.RoomType;
import com.aelatrouz.booking.service.HotelService;
import com.aelatrouz.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room save(RoomDTO roomDTO) {
        Room room = new Room();
        Hotel hotel = hotelRepository.findById(roomDTO.getHotelId()).orElse(null);
        if (hotel == null) {
            throw new EntityNotFoundException("Hotel with id " + roomDTO.getHotelId() + " not found!!");
        }
        room.setHotel(hotel);
        room.setRoomType(RoomType.valueOf(roomDTO.getRoomType()));
        room.setNumBeds(roomDTO.getNumBeds());
        room.setPrice(roomDTO.getPrice());
        room.setAvailability(roomDTO.isAvailability());
        return roomRepository.save(room);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }



    @Override
    public void delete(Room room) {
        roomRepository.delete(room);
    }
}