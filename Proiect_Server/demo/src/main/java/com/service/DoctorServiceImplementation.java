package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Doctor;
import com.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImplementation implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorServiceImplementation() {
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return (Doctor)this.doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Integer id) {
        return this.doctorRepository.findById(id);
    }
}
