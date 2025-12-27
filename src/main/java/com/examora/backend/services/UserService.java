package com.examora.backend.services;

import com.examora.backend.dto.RegisterRequest;
import com.examora.backend.dto.UserResponse;

/**
 * Service layer for all user related operations
 * Handles business logic for registration & user management
 */
public interface UserService {

    // Register Student user (Public Signup)
    UserResponse registerStudent(RegisterRequest request);

    // Register Admin user (Restricted usage)
    UserResponse registerAdmin(RegisterRequest request);
}
