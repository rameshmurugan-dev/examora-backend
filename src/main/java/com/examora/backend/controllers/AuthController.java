package com.examora.backend.controllers;

import com.examora.backend.dto.RegisterRequest;
import com.examora.backend.dto.UserResponse;
import com.examora.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for handling authentication
 * and public registration endpoints.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    /** Business service for user registration and management */
    private final UserService userService;

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerStudent(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerStudent(request));
    }

    /**
     * Create Admin User
     * This will be used only by system / future admin panel
     */
    @PostMapping("/admin/register")
    public ResponseEntity<UserResponse> registerAdmin(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerAdmin(request));
    }

}
