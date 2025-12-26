package com.examora.backend.config;

import com.examora.backend.entities.Role;
import com.examora.backend.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        if(roleRepository.count() == 0) {

            roleRepository.save(Role.builder().roleName("ADMIN").build());
            roleRepository.save(Role.builder().roleName("STUDENT").build());

            System.out.println("➡ Default roles inserted");
        }
        
    }
}
