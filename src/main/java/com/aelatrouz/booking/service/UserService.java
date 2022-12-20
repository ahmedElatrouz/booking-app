package com.aelatrouz.booking.service;

import com.aelatrouz.booking.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void delete(User user);

    void delete(Long id);

    User update(Long id, User user);
}
