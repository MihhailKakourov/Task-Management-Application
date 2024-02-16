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
        // Получаем текущего пользователя
        User currentUser = userService.getCurrentUser();
        Integer userId = currentUser.getId();

        // Получаем список задач для текущего пользователя
        List<Task> tasks = taskAddService.getTasksByUserId(userId);

        // Передаем список задач в модель для отображения на странице
        model.addAttribute("tasks", tasks);

        // Возвращаем имя представления (шаблона), где будут отображены задачи
        return "tasks";
    }
}
