package com.example.todolist.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long taskId;

    @Column(nullable = false, length = 50)
    String taskTitle;

    @Column(length = 1000)
    String taskDescription;

    Date deadline;

    @Column(nullable = false)
    Boolean status;

    @ManyToOne
    @JoinColumn(name = "userId")
    User users;

    @ManyToMany
    @JoinTable(name = "taskAndCategory",
               joinColumns = @JoinColumn(name = "taskId"),
               inverseJoinColumns = @JoinColumn(name = "categoryId"))
    List<TaskCategory> categories;
}