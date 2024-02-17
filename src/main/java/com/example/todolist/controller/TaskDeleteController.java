package com.example.todolist.controller;

import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.TaskDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskDeleteController {
    private final TaskDeleteService taskDeleteService;
    private final UserRepository userRepository;

    public TaskDeleteController(TaskDeleteService taskDeleteService, UserRepository userRepository) {
        this.taskDeleteService = taskDeleteService;
        this.userRepository = userRepository;
    }
    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam Long taskId) {
        taskDeleteService.deleteTask(taskId);
        return "redirect:/tasks";
    }
}
