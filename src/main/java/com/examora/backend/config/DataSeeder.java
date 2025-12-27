package com.examora.backend.config;

import com.examora.backend.entities.Role;
import com.examora.backend.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Seeds initial master data into the database at application startup.
 *
 * This class ensures that default system roles are created only once.
 * It runs automatically after the Spring Boot application context loads.
 */
@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    /** Repository used to perform CRUD operations on Role entity */
    private final RoleRepository roleRepository;

    /**
     * Executes on application startup.
     * Inserts default roles only if the roles table is empty.
     */
    @Override
    public void run(String... args) {

        // Insert roles only when table has no existing data
        if(roleRepository.count() == 0) {

            roleRepository.save(Role.builder().roleName("ADMIN").build());
            roleRepository.save(Role.builder().roleName("STUDENT").build());

            System.out.println("➡ Default roles inserted");
        }
        
    }
}
