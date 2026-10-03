package com.example.parcial.repository;

import com.example.parcial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);
}
