package com.example.todolist.Controllers;

import com.example.todolist.Models.Task;
import com.example.todolist.Models.User;
import com.example.todolist.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getAllTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/list";
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model){
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task/details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("task", new Task());
        return "task/create";
    }

    @GetMapping
    public String getTaskByUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("tasks", taskService.getTaskByUser(user));
        return "tasks";
    }

    @GetMapping
    public String getTaskByTaskCategory(Model model, @ModelAttribute("categoryName") String categoryName) {
        model.addAttribute("tasks", taskService.getTaskByTaskCategory(categoryName));
        return "tasks :: task";
    }

    @GetMapping
    public String searchTaskByKeyword(Model model, String keyword) {
        model.addAttribute("tasks", taskService.searchTaskByKeyword(keyword));
        return "tasks";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task){
        taskService.createTask(task);
        return "redirect:/tasks";
    }


    @GetMapping("/{id}/delete")
    public String deleteTaskById(@PathVariable Long task_id){
        taskService.deleteTaskById(task_id);
        return "redirect:/tasks";
    }

    @GetMapping("/delete")
    public String deleteTaskByUser(@AuthenticationPrincipal User user) {
        taskService.deleteTaskByUser(user);
        return "redirect:/tasks";
    }
}
