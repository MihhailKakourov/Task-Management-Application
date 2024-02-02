package com.example.todolist.Services;
import com.example.todolist.Models.Role;
import com.example.todolist.Models.Task;
import com.example.todolist.Models.User;
import com.example.todolist.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long user_id){
        return userRepository.findById(user_id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUserByRole(Role role) {
        return userRepository.findUserByRole(role);
    }

    public List<User> getUserByTask(Task task) {
        return userRepository.findUserByTask(task);
    }

    public List<User> searchUserByKeyword(String keyword){
        return userRepository.searchByKeyword(keyword);
    }

    public void deleteUserByName(String username){
        userRepository.deleteUserByName(username);
    }

    public void deleteUserById(Long user_id){
        userRepository.deleteById(user_id);
    }
}
