package com.example.parcial.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name="seatRequests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class SeatRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tripId;

    private String passengerId;

    private ZonedDateTime requestedAt;

    @Enumerated(EnumType.STRING)
    private SeatRequestType status;

}