package com.service;

import com.model.Consultatie;
import com.model.Pacient;

import java.util.List;
import java.util.Optional;

public interface PacientService {
    Pacient savePacient(Pacient pacient);
    List<Pacient> findAll();
    Optional<Pacient> findById(Integer id);
    Pacient updateDataForPacient(Pacient pacient);
}
