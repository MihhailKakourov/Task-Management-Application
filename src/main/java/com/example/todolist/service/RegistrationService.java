package com.example.todolist.service;

import com.example.todolist.model.Role;
import com.example.todolist.model.User;
import com.example.todolist.repository.RoleRepository;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewUser(String username, String password) {
        Optional<Role> userRoleOptional = roleRepository.findByName("ROLE_USER");
        if (!userRoleOptional.isPresent()) {
            throw new IllegalStateException("Role ROLE_USER not found");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoleList(Collections.singletonList(userRoleOptional.get())); // Используем полученную роль
        userRepository.save(user);
    }
}
