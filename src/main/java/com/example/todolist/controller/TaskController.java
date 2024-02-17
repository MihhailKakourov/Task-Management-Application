package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskAddService;
import com.example.todolist.service.TaskChangeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskAddService taskAddService;
    private final TaskChangeService taskChangeService;

    public TaskController(TaskAddService taskAddService, TaskChangeService taskChangeService) {
        this.taskAddService = taskAddService;
        this.taskChangeService = taskChangeService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskAddService.getAllTasks();
    }
}

