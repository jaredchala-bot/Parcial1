package com.example.parcial.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.ZonedDateTime;

public class TripRequestDTO {

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    private ZonedDateTime departureTime;

    private Integer capacity;
}
