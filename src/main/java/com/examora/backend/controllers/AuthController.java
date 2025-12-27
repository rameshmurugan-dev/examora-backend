package com.examora.backend.controllers;

import com.examora.backend.dto.RegisterRequest;
import com.examora.backend.dto.UserResponse;
import com.examora.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerStudent(
            @Valid @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(userService.registerStudent(request));
    }
}
