package com.example.parcial.service;

import com.example.parcial.model.Trip;
import com.example.parcial.repository.TripRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {
    private final ModelMapper modelMapper;
    private final TripRepository tripRepository;

    public createTrip(tripRequestDTO tripDTO) {
        Trip trip = modelMapper.map(tripDTO,Trip.class);

    }
    public getAllTrips(String username) {

    }
}
