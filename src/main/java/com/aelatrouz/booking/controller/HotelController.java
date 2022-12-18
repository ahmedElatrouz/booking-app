package com.aelatrouz.booking.controller;

import com.aelatrouz.booking.entity.Hotel;
import com.aelatrouz.booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        List<Hotel> hotels = hotelService.findAll();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Long id) {
        Hotel hotel = hotelService.findById(id);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel);
    }

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.save(hotel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedHotel.getId()).toUri();
        return ResponseEntity.created(location).body(savedHotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Hotel hotel = hotelService.findById(id);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        hotelService.delete(hotel);
        return ResponseEntity.noContent().build();
    }
}
