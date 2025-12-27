package com.examora.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration for Examora backend
 * Controls which APIs are public and which require authentication
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Disable CSRF for REST APIs (recommended for stateless APIs)
                .csrf(csrf -> csrf.disable())

                // Define access rules for API endpoints
                .authorizeHttpRequests(auth -> auth

                        // Public APIs — NO authentication required
                        .requestMatchers(
                                "/api/auth/register", // Student Register
                                "/api/auth/admin/register", // Admin Register
                                "/api/auth/login" // (will be used later in JWT)
                        ).permitAll()

                        // All other APIs require authentication (will protect later with JWT)
                        .anyRequest().authenticated())

                // Enable basic auth temporarily (we will replace with JWT later)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
