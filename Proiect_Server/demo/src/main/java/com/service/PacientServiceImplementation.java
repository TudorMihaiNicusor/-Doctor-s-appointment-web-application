package com.service;

import com.model.Consultatie;
import com.repository.ConsultatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.model.Pacient;
import com.repository.PacientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacientServiceImplementation implements PacientService{
    @Autowired
    private PacientRepository pacientRepository;

    public PacientServiceImplementation() {
    }

    @Override
    public Pacient savePacient(Pacient pacient) {
        return (Pacient)this.pacientRepository.save(pacient);
    }

    @Override
    public List<Pacient> findAll() {
        return this.pacientRepository.findAll();
    }

    @Override
    public Optional<Pacient> findById(Integer id) {
        return this.pacientRepository.findById(id);
    }

    @Override
    public Pacient updateDataForPacient(Pacient pacient) {
        return (Pacient)this.pacientRepository.save(pacient);
    }
}
