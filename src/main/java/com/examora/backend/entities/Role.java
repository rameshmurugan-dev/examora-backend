package com.examora.backend.entities;

import jakarta.persistence.*;
import lombok.*;


/**
 * Represents application security role.
 * Each user is associated with exactly one role.
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    /** Primary key (auto-generated) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Unique role name (ADMIN / STUDENT / etc.) */
    @Column(nullable = false, unique = true, length = 30)
    private String roleName;
}
