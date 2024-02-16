package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskAddService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskAddService taskAddService;

    public TaskController(TaskAddService taskAddService) {
        this.taskAddService = taskAddService;
    }

    @GetMapping("/tasks") // Изменяем маппинг
    public List<Task> getTasks() {
        return taskAddService.getAllTasks();
    }
}