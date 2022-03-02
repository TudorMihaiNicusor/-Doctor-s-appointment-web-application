package com.repository;

import com.model.Consultatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultatieRepository extends JpaRepository<Consultatie, Integer> {
    @Query(value ="SELECT consultatie.temperatura FROM consultatie WHERE pacient_id=?1" ,nativeQuery = true)
    Optional<List<String>> findbyclientidtemperatura(Integer id);
}
