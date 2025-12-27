package com.examora.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO returned after successful user creation / retrieval.
 * Contains only non-sensitive public user details.
 */
@Getter
@Setter
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String role;
}
