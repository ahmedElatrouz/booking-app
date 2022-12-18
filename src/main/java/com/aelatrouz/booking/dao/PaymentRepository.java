package com.aelatrouz.booking.dao;

import com.aelatrouz.booking.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Optional custom repository methods go here
}
