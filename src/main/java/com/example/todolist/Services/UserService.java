package com.example.todolist.Services;
import com.example.todolist.Models.Role;
import com.example.todolist.Models.Task;
import com.example.todolist.Models.User;
import com.example.todolist.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void saveUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }
}
