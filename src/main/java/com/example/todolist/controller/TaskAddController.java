package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.TaskAddService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
//public class TaskAddController {
//    private final TaskAddService taskAddService;
//
//    public TaskAddController(TaskAddService taskAddService) {
//        this.taskAddService = taskAddService;
//    }
//
//    @PostMapping("/task_add")
//    public String addTask(Task task) {
//        taskAddService.addTask(task);
//        return "redirect:/tasks";
//    }
//}
@Controller
public class TaskAddController {
    private final TaskAddService taskAddService;
    private final UserRepository userRepository;

    public TaskAddController(TaskAddService taskAddService, UserRepository userRepository) {
        this.taskAddService = taskAddService;
        this.userRepository = userRepository;
    }

    @PostMapping("/task_add")
    public String addTask(Task task) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();

            User user = userRepository.findByUsername(username);

            task.setUsers(user);

            taskAddService.addTask(task);
            return "redirect:/tasks";
        } else {
            return "redirect:/login";
        }
    }
}




