package com.example.login.Config;

import com.example.login.Repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final EmployeeRepo repository;
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repository.findByEmail(username);
    }
}
