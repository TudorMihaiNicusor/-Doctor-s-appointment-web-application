package com.service;

import com.model.Consultatie;
import com.repository.ConsultatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultatieServiceImplementation implements ConsultatieService {

    @Autowired
    private ConsultatieRepository consultatieRepository;

    public ConsultatieServiceImplementation() {
    }

    @Override
    public Consultatie saveConsultatie(Consultatie consultatie) {
        return this.consultatieRepository.save(consultatie);
    }

    @Override
    public List<Consultatie> findAll() {
        return this.consultatieRepository.findAll();
    }

    @Override
    public Consultatie updateDataForConsultatie(Consultatie consultatie) {
        return this.consultatieRepository.save(consultatie);
    }

    @Override
    public Optional<Consultatie> findById(Integer id) {
        return this.consultatieRepository.findById(id);
    }

    @Override
    public Optional<List<String>> findbyclientidtemperatura(Integer id) {
        return this.consultatieRepository.findbyclientidtemperatura(id);
    }
}
