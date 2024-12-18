package com.example.LogisCode.service;

import com.example.LogisCode.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {


    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleById(Long id);

    void createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    void deleteVehicle(Long id);
}
