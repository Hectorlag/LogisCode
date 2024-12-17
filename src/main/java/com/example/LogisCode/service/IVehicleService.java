package com.example.LogisCode.service;

import com.example.LogisCode.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {


    List<Vehicle> getAllVehicle();

    Optional<Vehicle> getVehicleById(Long id);

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Long id, Vehicle vehicle);

    void deleteVehicle(Long id);
}
