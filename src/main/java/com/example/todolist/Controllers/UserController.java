package com.example.todolist.Controllers;

import com.example.todolist.Models.Role;
import com.example.todolist.Models.User;
import com.example.todolist.Services.TaskService;
import com.example.todolist.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/details";
    }

    @GetMapping
    public String searchUserByKeyword(Model model, String keyword) {
        model.addAttribute("tasks", userService.searchUserByKeyword(keyword));
        return "users";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteUserById(@PathVariable Long user_id) {
        userService.deleteUserById(user_id);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUserByName(@AuthenticationPrincipal User user) {
        userService.deleteUserByName(user.toString());
        return "redirect:/";
    }
}
