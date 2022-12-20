package com.aelatrouz.booking.controller;

import com.aelatrouz.booking.controller.dto.ReviewDTO;
import com.aelatrouz.booking.entity.Review;
import com.aelatrouz.booking.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@Validated
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Cacheable(value = "reviews")
    @GetMapping
    public ResponseEntity<List<Review>> findAll() {
        List<Review> reviews = reviewService.findAll();
        return ResponseEntity.ok(reviews);
    }

    @Cacheable(value = "reviews", key = "#id")
    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id) {
        Review review = reviewService.findById(id);
        if (review == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review);
    }

    //    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Review> save(@RequestBody @Validated ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());
        review.setDate(LocalDate.now());
        Review savedReview = reviewService.save(review);
        return ResponseEntity.ok(savedReview);
    }

    //    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CacheEvict(value = "reviews", key = "#id")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody @Validated ReviewDTO reviewDTO) {
        Review review = reviewService.findById(id);
        if (review == null) {
            return ResponseEntity.notFound().build();
        }
        review.setRating(reviewDTO.getRating());
        review.setComments(reviewDTO.getComments());
        Review updatedReview = reviewService.save(review);
        return ResponseEntity.ok(updatedReview);
    }

    //    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "reviews", key = "#id")
    public void delete(@PathVariable Long id) {
        Review review = reviewService.findById(id);
        if (review == null) {
            throw new EntityNotFoundException();
        }
        reviewService.delete(review);
    }


}
