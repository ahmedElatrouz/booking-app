package com.aelatrouz.booking.service.impl;

import com.aelatrouz.booking.dao.PaymentRepository;
import com.aelatrouz.booking.entity.Payment;
import com.aelatrouz.booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }
}

