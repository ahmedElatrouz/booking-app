package com.aelatrouz.booking.dao;

import com.aelatrouz.booking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Optional custom repository methods go here
}