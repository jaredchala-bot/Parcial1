package com.example.parcial.service;

import com.example.parcial.dto.LoginRequestDTO;
import com.example.parcial.dto.RegisterRequestDTO;
import com.example.parcial.dto.UserResponseDTO;
import com.example.parcial.exceptions.UserAlreadyExistsException;
import com.example.parcial.model.User;
import com.example.parcial.model.UserRole;
import com.example.parcial.repository.UserRepository;
import com.example.parcial.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO registerUser(RegisterRequestDTO dto) {
        if (userRepository.existsUserByUsername(dto.getUsername())) {
            throw new UserAlreadyExistsException("username is registered");
        }
        if (userRepository.existsUserByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("email is registered");
        }

        User user = modelMapper.map(dto,User.class);
        user.setPassword(PasswordEncoder.encode(dto,dto.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        User saved = userRepository.save(user);
        return modelMapper.map(saved,UserResponseDTO.class);
    }

    public UserResponseDTO loginUser(LoginRequestDTO dto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword())
        );
        UserDetails principal = (UserDetails) auth.getPrincipal();
        String token = JwtService.generateToken(principal);
        return new UserResponseDTO(); //falta
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("user not found" + id)
        );
        return modelMapper.map(user,UserResponseDTO.class);

    }

}
