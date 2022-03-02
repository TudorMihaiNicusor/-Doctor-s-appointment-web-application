package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT *, 0 AS clazz_ FROM USER WHERE USER.USERNAME = ?1", nativeQuery = true)
    public Optional<User> findByUsername(String username);
}