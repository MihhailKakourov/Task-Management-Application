package com.example.todolist.config;

import com.example.todolist.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(form -> form
                        .defaultSuccessUrl("/home", true)
                        .permitAll())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/home").permitAll() // Разрешаем доступ к главной странице
                        .requestMatchers("/register/**").permitAll() // Разрешаем доступ к странице регистрации
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // Разрешаем доступ к статическим ресурсам
                        .anyRequest().authenticated())
                .userDetailsService(userService)
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

