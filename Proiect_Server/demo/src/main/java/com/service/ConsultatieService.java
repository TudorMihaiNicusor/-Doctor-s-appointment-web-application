package com.service;

import com.model.Consultatie;

import java.util.List;
import java.util.Optional;

public interface ConsultatieService {
    Consultatie saveConsultatie(Consultatie consultatie);
    List<Consultatie> findAll();
    Consultatie updateDataForConsultatie(Consultatie consultatie);
    Optional<Consultatie> findById(Integer id);
    Optional<List<String>> findbyclientidtemperatura(Integer id);
}
