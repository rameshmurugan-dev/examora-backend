package com.examora.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*Configuration class responsible for defining password-security beans.*/
@Configuration
public class PasswordConfig {

    /* Password encoder bean used for hashing user passwords
     * before persisting them to the database.*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
