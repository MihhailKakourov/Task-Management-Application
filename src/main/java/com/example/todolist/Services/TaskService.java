package com.example.todolist.Services;
import com.example.todolist.Models.Task;
import com.example.todolist.Models.User;
import com.example.todolist.Models.TaskCategory;
import com.example.todolist.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long task_id){
        return taskRepository.findById(task_id).orElse(null);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

//    public List<Task> getTaskByUser(User user) {
//        return taskRepository.findByUser(user);
//    }

//    public List<Task> getTaskByTaskCategory(String categoryName) {
//        return taskRepository.findByTaskCategory(categoryName);
//    }

//    public List<Task> searchTaskByKeyword(String keyword){
//        return taskRepository.searchByKeyword(keyword);
//    }

//    public void deleteTaskByUser(User user){
//        taskRepository.deleteByUser(user);
//    }

    public void deleteTaskById(Long task_id){
        taskRepository.deleteById(task_id);
    }
}
