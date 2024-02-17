package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.model.User;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.service.TaskChangeService;
import com.example.todolist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskChangeController {

    private final TaskChangeService taskChangeService;
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskChangeController(TaskChangeService taskChangeService, TaskRepository taskRepository, UserService userService) {
        this.taskChangeService = taskChangeService;
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    @GetMapping("/edit_task")
    public String showUpdateTaskForm(@RequestParam Long id, Model model) {
        Task task = taskRepository.findById(id).orElse(null);
        model.addAttribute("task", task);
        return "update_task";
    }

    @PostMapping("/task_change")
    public String updateTask(@ModelAttribute Task task) {
        User currentUser = userService.getCurrentUser();
        task.setUsers(currentUser);

        taskChangeService.updateTask(task);
        return "redirect:/tasks";
    }

}