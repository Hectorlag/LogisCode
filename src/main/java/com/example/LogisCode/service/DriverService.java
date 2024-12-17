package com.example.LogisCode.service;

import com.example.LogisCode.model.Driver;
import com.example.LogisCode.model.Vehicle;
import com.example.LogisCode.repository.IDriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService implements IDriverService{

    private IDriverRepository iDriverRepository;

    public DriverService(IDriverRepository iDriverRepository) {
        this.iDriverRepository = iDriverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return iDriverRepository.findAll();
    }

    @Override
    public Optional<Driver> getDriverById(Long id) {
        return iDriverRepository.findById(id);
    }

    @Override
    public void createDriver(Driver driver) {
        iDriverRepository.save(driver);

    }

    @Override
    public Driver updateDriver(Driver driver) {
        Optional<Driver> d = this.getDriverById(driver.getId());
        if(d.isPresent()){

            Driver existingDriver = d.get();
            existingDriver.setName(driver.getName());
            return iDriverRepository.save(existingDriver);
            }
            return null;
        }

    @Override
    public void deleteDriver(Long id) {

    }
}
