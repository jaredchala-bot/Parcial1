package com.example.parcial.dto;

import com.example.parcial.model.SeatRequestType;
import com.example.parcial.model.TripStatus;
import com.example.parcial.model.UserRole;

public class RideDTO {

    private UserRole type;

    private Long tripId;

    //seat
    private SeatRequestType seatStatus;

    //trip
    private TripStatus tripStatus;
}
