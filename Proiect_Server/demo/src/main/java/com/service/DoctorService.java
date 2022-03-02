package com.service;

import com.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> findAll();
    Optional<Doctor> findById(Integer id);
}
