package com.repository;

import com.model.Consultatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.model.Pacient;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Integer> {
}
