package com.aelatrouz.booking.controller;

import com.aelatrouz.booking.entity.Room;
import com.aelatrouz.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> findAll() {
        List<Room> rooms = roomService.findAll();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        Room room = roomService.findById(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public ResponseEntity<Room> save(@RequestBody Room room) {
        Room savedRoom = roomService.save(room);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedRoom.getId()).toUri();
        return ResponseEntity.created(location).body(savedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Room room = roomService.findById(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        roomService.delete(room);
        return ResponseEntity.noContent().build();
    }
}
