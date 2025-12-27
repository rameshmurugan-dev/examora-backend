package com.examora.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Represents system user entity stored in database.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    /** Primary key identifier */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Full name of user */
    @Column(nullable = false, length = 100)
    private String name;

    /** Unique login email */
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    /** Encrypted password hash */
    @Column(nullable = false)
    private String password;

    /** User role reference */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    /** Account creation timestamp */
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
