package com.aelatrouz.booking.service.impl;

import com.aelatrouz.booking.dao.ReviewRepository;
import com.aelatrouz.booking.entity.Hotel;
import com.aelatrouz.booking.entity.Review;
import com.aelatrouz.booking.entity.User;
import com.aelatrouz.booking.service.HotelService;
import com.aelatrouz.booking.service.ReviewService;
import com.aelatrouz.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private UserService userService;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review save(Review review) {
        Hotel hotel = hotelService.findById(review.getHotel().getId());
        User user = userService.findById(review.getUser().getId());

        if (hotel == null || user == null) {
            throw new EntityNotFoundException();
        }

        review.setHotel(hotel);
        review.setUser(user);

        return reviewRepository.save(review);
    }

    @Override
    public void delete(Review review) {
        reviewRepository.delete(review);
    }
}

