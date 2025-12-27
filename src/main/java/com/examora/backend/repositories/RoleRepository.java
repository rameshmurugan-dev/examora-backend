package com.examora.backend.repositories;

import com.examora.backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository layer to perform CRUD operations on Role entity.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    //Fetch role by role name.
    Optional<Role> findByRoleName(String roleName);
}
