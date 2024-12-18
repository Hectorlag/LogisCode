package com.example.LogisCode.repository;

import com.example.LogisCode.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripRepository extends JpaRepository<Trip, Long> {

}
