package com.example.parcial.model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
