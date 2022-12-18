package com.aelatrouz.booking.service.impl;

import com.aelatrouz.booking.dao.BookingRepository;
import com.aelatrouz.booking.entity.Booking;
import com.aelatrouz.booking.entity.Payment;
import com.aelatrouz.booking.entity.Room;
import com.aelatrouz.booking.entity.User;
import com.aelatrouz.booking.service.BookingService;
import com.aelatrouz.booking.service.PaymentService;
import com.aelatrouz.booking.service.RoomService;
import com.aelatrouz.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking save(@Validated Booking booking) {
        Room room = roomService.findById(booking.getRoom().getId());
        User user = userService.findById(booking.getUser().getId());

        if (room == null || user == null) {
            throw new EntityNotFoundException();
        }

        if (!room.isAvailability()) {
            //  throw new RoomNotAvailableException();
        }

        room.setAvailability(false);
        roomService.save(room);

        booking.setRoom(room);
        booking.setUser(user);
        booking.setCost(room.getPrice() * booking.getNumGuests() * ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate()));

        Payment payment = new Payment();
        payment.setAmount(booking.getCost());
        payment.setBooking(booking);

        Payment savedPayment = paymentService.save(payment);
        booking.setPayment(savedPayment);

        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Booking booking) {
        Room room = booking.getRoom();
        room.setAvailability(true);
        roomService.save(room);

        bookingRepository.delete(booking);
    }
}
