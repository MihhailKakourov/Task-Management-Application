package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.model.User;
import com.example.todolist.service.UserService;
import com.example.todolist.service.TaskAddService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskViewController {
    private final TaskAddService taskAddService;
    private final UserService userService;

    public TaskViewController(TaskAddService taskAddService, UserService userService) {
        this.taskAddService = taskAddService;
        this.userService = userService;
    }

    @GetMapping("/tasks")
    public String viewTasks(Model model) {
        User currentUser = userService.getCurrentUser();
        Integer userId = currentUser.getId();

        List<Task> tasks = taskAddService.getTasksByUserId(userId);

        model.addAttribute("tasks", tasks);

        return "tasks";
    }
}
