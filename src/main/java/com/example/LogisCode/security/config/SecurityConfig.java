package com.example.LogisCode.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para simplificar pruebas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/drivers/**", "/api/vehicles/**", "/api/trips/**").authenticated() // Protege estas rutas para usuarios autenticados
                        .anyRequest().permitAll() // Permite todas las demás solicitudes
                )
                .formLogin(Customizer.withDefaults()) // Habilita formulario de login por defecto
                .oauth2Login(Customizer.withDefaults()) // Habilita login con OAuth2
                .build();
    }
}

