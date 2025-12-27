package com.examora.backend.services;

import com.examora.backend.dto.RegisterRequest;
import com.examora.backend.dto.UserResponse;

public interface UserService {

    UserResponse registerStudent(RegisterRequest request);
}
