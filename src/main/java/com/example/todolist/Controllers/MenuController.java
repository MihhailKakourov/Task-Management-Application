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
}
