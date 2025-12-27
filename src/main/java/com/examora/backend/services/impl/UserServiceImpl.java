package com.examora.backend.services.impl;

import com.examora.backend.dto.RegisterRequest;
import com.examora.backend.dto.UserResponse;
import com.examora.backend.entities.Role;
import com.examora.backend.entities.User;
import com.examora.backend.repositories.RoleRepository;
import com.examora.backend.repositories.UserRepository;
import com.examora.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Concrete implementation of UserService.
 * Contains business logic for user registration workflows.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
     
    /**
     * Registers a new student user.
     * Validates email uniqueness & assigns STUDENT role.
     */
    @Override
    public UserResponse registerStudent(RegisterRequest request) {

        // Validate email uniqueness
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        //Fetch STUDENT role from DB
        Role studentRole = roleRepository.findByRoleName("STUDENT")
                .orElseThrow(() -> new RuntimeException("STUDENT role not found"));

        //Create new STUDENT User
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                // Encode password before saving
                .password(passwordEncoder.encode(request.getPassword()))
                .role(studentRole)
                .build();

        userRepository.save(user);

        //Return clean response object (no password)
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().getRoleName())
                .build();
    }


    //Override method to register admin users
    @Override
    public UserResponse registerAdmin(RegisterRequest request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // Fetch ADMIN role from DB
        Role adminRole = roleRepository.findByRoleName("ADMIN")
                .orElseThrow(() -> new RuntimeException("ADMIN role not found"));

        // Create new Admin user
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                // Encode password before saving
                .password(passwordEncoder.encode(request.getPassword()))
                .role(adminRole)
                .build();

        userRepository.save(user);

        // Return clean response object (no password)
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().getRoleName())
                .build();
    }

}
