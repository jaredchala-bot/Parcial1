package com.example.parcial.repository;

import com.example.parcial.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {

}
