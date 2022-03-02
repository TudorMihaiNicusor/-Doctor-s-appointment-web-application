package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.model.Doctor;
import com.service.DoctorService;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    public DoctorController(){

    }

    @GetMapping(value="/doctor/findall")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @PostMapping(value="/doctor/saveDoctor")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping(value="/doctor/findbyid/{id}")
    public Optional<Doctor> findById(@PathVariable Integer id){
        return doctorService.findById(id);
    }
}
