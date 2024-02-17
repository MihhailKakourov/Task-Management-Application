package com.example.todolist.service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAddService {
    private final TaskRepository taskRepository;

    public TaskAddService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        try {
            taskRepository.save(task);
            System.out.println("Task added successfully: " + task.getTaskId());
        } catch (Exception e) {
            System.out.println("Failed to add task");
            e.printStackTrace();
        }
    }

    public List<Task> getTasksByUserId(Integer userId) {
        return taskRepository.findByUsersId(userId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
