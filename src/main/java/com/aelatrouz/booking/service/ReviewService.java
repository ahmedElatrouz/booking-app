package com.aelatrouz.booking.service;

import com.aelatrouz.booking.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review findById(Long id);
    Review save(Review review);
    void delete(Review review);
}
