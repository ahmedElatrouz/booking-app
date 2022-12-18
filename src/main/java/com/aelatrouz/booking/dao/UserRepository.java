package com.aelatrouz.booking.dao;

import com.aelatrouz.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional custom repository methods go here
}