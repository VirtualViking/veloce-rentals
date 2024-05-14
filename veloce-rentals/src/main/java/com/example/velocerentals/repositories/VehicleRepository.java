package com.example.velocerentals.repositories;

import com.example.velocerentals.domain.models.Vehicle;
import com.example.velocerentals.repositories.search_criteria.VehicleSearchCriteria;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {

    boolean save (Vehicle vehicle);
    List<Vehicle> findAll();
    List<Vehicle> findByCriteria(VehicleSearchCriteria criteria);
    Optional<Vehicle> findById(Long id);
}
