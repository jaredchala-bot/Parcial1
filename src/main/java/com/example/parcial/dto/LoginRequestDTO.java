package com.example.parcial.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginRequestDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
