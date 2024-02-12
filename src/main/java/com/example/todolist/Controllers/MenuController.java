package com.example.todolist.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/")
    public String viewPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "index";
    }

    @GetMapping("/lists")
    public String listPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "lists";
    }

    @GetMapping("/contacts")
    public String contactPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "contacts";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "login";
    }

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "signup";
    }

    @GetMapping("/task_do")
    public String taskDoPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "task_do";
    }

    @GetMapping("/task_add")
    public String taskAddPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "task_add";
    }

    @GetMapping("/task_list")
    public String taskListPage(Model model) {
        model.addAttribute("header", "ToDoList");
        return "task_list";
    }
}
