package com.example.LogisCode.service;

import com.example.LogisCode.model.Trip;
import com.example.LogisCode.repository.ITripRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService implements ITripService{

    private ITripRepository iTripRepository;

    public TripService(ITripRepository iTripRepository) {
        this.iTripRepository = iTripRepository;
    }

    @Override
    public List<Trip> getAllTrips() {
        return iTripRepository.findAll();
    }

    @Override
    public Optional<Trip> getTripById(Long id) {
        return iTripRepository.findById(id);
    }

    @Override
    public void createTrip(Trip trip) {
        iTripRepository.save(trip);
    }

    @Override
    public Trip updateTrip(Trip trip) {
        Optional<Trip> t = this.getTripById(trip.getId());
        if (t.isPresent()) {
            Trip existingTrip = t.get();
            // Actualizar otros campos según sea necesario
            return iTripRepository.save(existingTrip);
        }
        return null;
    }

    @Override
    public void deleteTrip(Long id) {
        Optional<Trip> trip = this.getTripById(id);
        if (trip.isPresent()) {
            Trip existingTrip = trip.get();
            existingTrip.setDeleted(true);
            iTripRepository.save(existingTrip);
        } else {
            throw new EntityNotFoundException("Trip with id " + id + " not found");
        }
    }
}
