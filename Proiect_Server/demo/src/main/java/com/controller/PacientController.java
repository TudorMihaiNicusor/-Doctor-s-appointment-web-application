package com.controller;

import com.model.Consultatie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.model.Pacient;
import com.service.PacientService;

import java.util.List;
import java.util.Optional;

@RestController
public class PacientController {

    @Autowired
    private PacientService pacientService;

    public PacientController() {
    }

    @GetMapping(value="/pacient/findall")
    public List<Pacient> findAll(){
        return pacientService.findAll();
    }

    @PostMapping(value="/pacient/savePacient")
    public Pacient savePacient(@RequestBody Pacient pacient){
        return pacientService.savePacient(pacient);
    }

    @GetMapping(value="/pacient/findbyid/{id}")
    public Optional<Pacient> findById(@PathVariable Integer id){
        return pacientService.findById(id);
    }

    @PostMapping(value = "/pacient/updateData")
    public Pacient updateDataForPacient(@RequestBody Pacient pacient){
        return pacientService.updateDataForPacient(pacient);
    }
}
