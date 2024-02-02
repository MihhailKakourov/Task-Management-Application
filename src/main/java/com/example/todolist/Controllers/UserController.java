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
    public UserController(UserService UserService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/details";
    }

//    @GetMapping("/create")
//    public String showCreateForm(Model model){
//        model.addAttribute("task", new Task());
//        return "task/create";
//    }

//    @GetMapping
//    public String getUserByTask(Model model, @AuthenticationPrincipal User user) {
//        model.addAttribute("tasks", taskService.getTaskByUser(user));
//        return "tasks";
//    }
//
//    @GetMapping
//    public String getTaskByTaskCategory(Model model, @ModelAttribute("categoryName") String categoryName) {
//        model.addAttribute("tasks", taskService.getTaskByTaskCategory(categoryName));
//        return "tasks :: task";
//    }
//
//    @GetMapping
//    public String searchTaskByKeyword(Model model, String keyword) {
//        model.addAttribute("tasks", taskService.searchTaskByKeyword(keyword));
//        return "tasks";
//    }
//
//    @PostMapping("/create")
//    public String createTask(@ModelAttribute Task task){
//        taskService.createTask(task);
//        return "redirect:/tasks";
//    }
//
//
//    @GetMapping("/{id}/delete")
//    public String deleteTaskById(@PathVariable Long task_id){
//        taskService.deleteTaskById(task_id);
//        return "redirect:/tasks";
//    }
//
//    @GetMapping("/delete")
//    public String deleteTaskByUser(@AuthenticationPrincipal User user) {
//        taskService.deleteTaskByUser(user);
//        return "redirect:/tasks";
//    }
}
