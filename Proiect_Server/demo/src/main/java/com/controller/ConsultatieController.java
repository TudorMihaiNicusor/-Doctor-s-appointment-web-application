package com.controller;

import com.model.Consultatie;
import com.service.ConsultatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsultatieController {

    @Autowired
    private ConsultatieService consultatieService;

    public ConsultatieController(){

    }

    @GetMapping(value="/consultatie/findall")
    public List<Consultatie> findAll(){
        return consultatieService.findAll();
    }

    @RequestMapping(value="/consultatie/saveConsultatie", method = RequestMethod.POST)
    public Consultatie saveConsultatie(@RequestBody Consultatie consultatie){
        return consultatieService.saveConsultatie(consultatie);
    }

    @PostMapping(value = "/consultatie/updateData")
    public Consultatie updateDataForConsultatie(@RequestBody Consultatie consultatie){
        return consultatieService.updateDataForConsultatie(consultatie);
    }

    @GetMapping(value="/consultatie/findbyid/{id}")
    public Optional<Consultatie> findById(@PathVariable Integer id){
        return consultatieService.findById(id);
    }

    @ResponseBody
    @GetMapping(value="/consultatie/findbyclientidtemperatura/{id}")
    public Optional<List<String>> findbyclientidtemperatura(@PathVariable Integer id){
        return consultatieService.findbyclientidtemperatura(id);
    }
}
