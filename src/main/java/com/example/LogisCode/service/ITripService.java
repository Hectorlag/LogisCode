package com.example.LogisCode.service;

import com.example.LogisCode.model.Trip;

import java.util.List;
import java.util.Optional;

public interface ITripService {


    List<Trip> getAllTrips();

    Optional<Trip> getTripById(Long id);

    Trip createTrip(Trip trip);

    Trip updateTrip(Long id, Trip tripDetails);

    void deleteTrip(Long id);
}
