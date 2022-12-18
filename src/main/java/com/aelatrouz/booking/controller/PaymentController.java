package com.aelatrouz.booking.controller;

import com.aelatrouz.booking.controller.dto.PaymentDTO;
import com.aelatrouz.booking.entity.Payment;
import com.aelatrouz.booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/payments")
@Validated
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Cacheable(value = "payments")
    @GetMapping
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> payments = paymentService.findAll();
        return ResponseEntity.ok(payments);
    }

    @Cacheable(value = "payments", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id) {
        Payment payment = paymentService.findById(id);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payment);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Payment> save(@RequestBody @Validated PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
        Payment savedPayment = paymentService.save(payment);
        return ResponseEntity.ok(savedPayment);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CacheEvict(value = "payments", key = "#id")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody @Validated PaymentDTO paymentDTO) {
        Payment payment = paymentService.findById(id);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
        Payment updatedPayment = paymentService.save(payment);
        return ResponseEntity.ok(updatedPayment);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "payments", key = "#id")
    public void delete(@PathVariable Long id) {
        Payment payment = paymentService.findById(id);
        if (payment == null) {
            throw new EntityNotFoundException();
        }
        paymentService.delete(payment);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFoundException() {}
}
