package com.example.parcial.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name="trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name="driver_id",nullable = false)
    private User user;

    private String routeId;

    private ZonedDateTime departureTime;

    private Integer availableSeats;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

}