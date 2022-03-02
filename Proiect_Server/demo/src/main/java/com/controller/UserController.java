package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.model.Doctor;
import com.model.Pacient;
import com.model.User;
import com.service.DoctorService;
import com.service.PacientService;
import com.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PacientService pacientService;

    @Autowired
    private RestTemplate restTemplate;

    public UserController() {
    }

    @GetMapping(value = "/user/findall")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/user/findbyusername/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping(value = "/user/saveUser")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
