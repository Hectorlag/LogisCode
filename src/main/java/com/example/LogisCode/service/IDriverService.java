package com.example.LogisCode.service;

import com.example.LogisCode.model.Driver;
import com.example.LogisCode.model.Vehicle;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IDriverService {

    List<Driver> getAllDrivers();

    Optional<Driver> getDriverById(Long id);

    void createDriver(Driver driver);

    Vehicle updateDriver(Driver driver);

    void deleteDriver(Long id);


}
