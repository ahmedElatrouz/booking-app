package com.aelatrouz.booking.service;

import com.aelatrouz.booking.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll();
    Payment findById(Long id);
    Payment save(Payment payment);
    void delete(Payment payment);
}
