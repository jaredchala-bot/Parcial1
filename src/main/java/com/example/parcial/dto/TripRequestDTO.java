package com.example.parcial.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TripRequestDTO {

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    @Future
    private ZonedDateTime departureTime;

    @Min(1)
    @Max(6)
    private Integer capacity;
}
