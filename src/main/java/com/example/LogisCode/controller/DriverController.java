package com.example.LogisCode.controller;

import com.example.LogisCode.model.Driver;
import com.example.LogisCode.service.IDriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final IDriverService driverService;

    public DriverController(IDriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        Optional<Driver> driver = driverService.getDriverById(id);
        return driver.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    // Solo ADMIN puede crear nuevos choferes
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        driverService.createDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driver);
    }

    @PutMapping("/{id}")
    // Solo ADMIN puede actualizar nuevos choferes
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        driver.setId(id);  // Asegúrate de que el id recibido esté en el objeto driver
        Driver updatedDriver = driverService.updateDriver(driver);
        if (updatedDriver != null) {
            return ResponseEntity.ok(updatedDriver);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    // Solo ADMIN puede eliminar choferes
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

}
