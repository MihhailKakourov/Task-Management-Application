package com.example.todolist.service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class TaskChangeService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskChangeService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }
}