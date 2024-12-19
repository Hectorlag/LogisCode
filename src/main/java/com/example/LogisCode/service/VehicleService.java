package com.example.LogisCode.service;

import com.example.LogisCode.model.Vehicle;
import com.example.LogisCode.repository.IVehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService{

    private IVehicleRepository iVehicleRepository;

    public VehicleService(IVehicleRepository iVehicleRepository) {
        this.iVehicleRepository = iVehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return iVehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return iVehicleRepository.findById(id);
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        iVehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Optional<Vehicle> v = this.getVehicleById(vehicle.getId());
        if (v.isPresent()) {
            Vehicle existingVehicle = v.get();
            existingVehicle.setModel(vehicle.getModel());
            // Actualizar otros campos según sea necesario
            return iVehicleRepository.save(existingVehicle);
        }
        return null;
    }

    @Override
    public void deleteVehicle(Long id) {
        Optional<Vehicle> vehicle = this.getVehicleById(id);
        if (vehicle.isPresent()) {
            Vehicle existingVehicle = vehicle.get();
            existingVehicle.setDeleted(true);
            iVehicleRepository.save(existingVehicle);
        } else {
            throw new EntityNotFoundException("Vehicle with id " + id + " not found");
        }
    }

}
