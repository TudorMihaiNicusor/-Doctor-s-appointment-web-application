package com.service;

import com.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> findAll();
    Optional<User> findByUsername(String username);
}
