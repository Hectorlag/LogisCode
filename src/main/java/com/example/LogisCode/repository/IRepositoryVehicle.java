package com.example.LogisCode.repository;

import com.example.LogisCode.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryVehicle extends JpaRepository<Vehicle, Long> {


}