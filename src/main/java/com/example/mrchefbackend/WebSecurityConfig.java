package com.example.mrchefbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig {

    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable() // Desactiva CSRF (puedes ajustarlo según tus necesidades)
                .authorizeRequests(authz -> authz
                    .requestMatchers(HttpMethod.POST, "/recetas/crear").authenticated() // Protege /recetas/crear, requiere autenticación
                    .requestMatchers(HttpMethod.POST, Constants.LOGIN_URL).permitAll() // Permite el acceso al login sin autenticación
                    .anyRequest().authenticated() // Protege cualquier otro endpoint
                )
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class); // Añade el filtro JWT

        return http.build();
    }
}
