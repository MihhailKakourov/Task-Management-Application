package com.example.todolist.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "index";
    }

    @GetMapping("/contacts")
    public String contactsPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "contacts";
    }

    @GetMapping("/task_do")
    public String taskDoPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // Получаем имя текущего пользователя
        model.addAttribute("username", username);
        model.addAttribute("header", "ToDoList");
        return "task_do";
    }

    @GetMapping("/task_add")
    public String taskAddPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "task_add";
    }
}
