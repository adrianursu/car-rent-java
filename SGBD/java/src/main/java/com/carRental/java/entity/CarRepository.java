package com.carRental.java.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository
        extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c WHERE c.id = ?1")
    Optional<Car> findCarById(Integer id);
}